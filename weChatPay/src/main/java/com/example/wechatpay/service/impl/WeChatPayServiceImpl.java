package com.example.wechatpay.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.wechatpay.entity.PayHistoryPo;
import com.example.wechatpay.service.WeChatPayService;
import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.notification.Notification;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationHandler;
import com.wechat.pay.contrib.apache.httpclient.notification.NotificationRequest;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@Component
@Slf4j
public class WeChatPayServiceImpl implements WeChatPayService {

    /**
     * 小程序appId
     */
    private String appId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 证书序列号
     */
    private String merchantSerialNumber;

    /**
     * 私钥文件路径
     */
    private String certKeyPath;

    /**
     * 商户密钥
     */
    private String apiV3Key;
    /**
     * 微信专业httpClient
     */
    private static CloseableHttpClient httpClient;
    /**
     * 生成签名用
     */
    private static Sign sign;

    /**
     * 证书管理器
     */
    private static CertificatesManager certificatesManager;


    @PostConstruct
    public void init() throws Exception {
        log.info("私钥路径:{}", certKeyPath);
        PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(new FileInputStream(certKeyPath));
        // 获取证书管理器实例
        certificatesManager = CertificatesManager.getInstance();
        sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, merchantPrivateKey.getEncoded(), null);

        // 向证书管理器增加需要自动更新平台证书的商户信息
        certificatesManager.putMerchant(merchantId, new WechatPay2Credentials(merchantId,
                new PrivateKeySigner(merchantSerialNumber, merchantPrivateKey)), apiV3Key.getBytes(StandardCharsets.UTF_8));
        // 从证书管理器中获取verifier
        Verifier verifier = certificatesManager.getVerifier(merchantId);
        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(merchantId, merchantSerialNumber, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(verifier));
        httpClient = builder.build();
    }

    @Override
    public Map<String, String> pay(PayHistoryPo body) {
        long now = System.currentTimeMillis();
        JSONObject obj = new JSONObject();
        obj.put("mchid", merchantId);
        obj.put("appid", appId);
        obj.put("description", body.getDescription());
        obj.put("out_trade_no", body.getSn());
        obj.put("notify_url", "https://backend/asdfasdf/notify");
        Map<String, String> attach = new HashMap<>();
        attach.put("sn", body.getSn());
        obj.put("attach", JSON.toJSONString(attach));
        JSONObject amount = new JSONObject();
        amount.put("total", body.getPrice().multiply(BigDecimal.valueOf(100)).intValue());
        obj.put("amount", amount);
        JSONObject payer = new JSONObject();
        //放入用户的openId
        payer.put("openid", "");
        obj.put("payer", payer);
        log.info("请求参数为：" + JSON.toJSONString(obj));
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi");
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setEntity(new StringEntity(obj.toJSONString(), "UTF-8"));
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            String prePayId = JSONObject.parseObject(bodyAsString).getString("prepay_id");

            //准备小程序端的请求参数
            Map<String, String> map = new HashMap<>(6);
            map.put("appId", appId);
            String timeStamp = String.valueOf(now / 1000);
            map.put("timeStamp", timeStamp);
            String nonceStr = IdUtil.fastSimpleUUID();
            map.put("nonceStr", nonceStr);
            String packageStr = "prepay_id=" + prePayId;
            map.put("package", packageStr);
            map.put("signType", "RSA");
            map.put("paySign", Base64.encode(sign.sign(appId + "\n" + timeStamp + "\n" + nonceStr + "\n" + packageStr + "\n")));
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notify(HttpServletRequest servletRequest) {

        String timeStamp = servletRequest.getHeader("Wechatpay-Timestamp");
        String nonce = servletRequest.getHeader("Wechatpay-Nonce");
        String signature = servletRequest.getHeader("Wechatpay-Signature");
        String certSn = servletRequest.getHeader("Wechatpay-Serial");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(servletRequest.getInputStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String obj = stringBuilder.toString();
            log.info("回调数据:{},{},{},{},{}", obj, timeStamp, nonce, signature, certSn);
            Verifier verifier = certificatesManager.getVerifier(merchantId);
            String sn = verifier.getValidCertificate().getSerialNumber().toString(16).toUpperCase(Locale.ROOT);
            NotificationRequest request = new NotificationRequest.Builder().withSerialNumber(sn)
                    .withNonce(nonce)
                    .withTimestamp(timeStamp)
                    .withSignature(signature)
                    .withBody(obj)
                    .build();
            NotificationHandler handler = new NotificationHandler(verifier, apiV3Key.getBytes(StandardCharsets.UTF_8));
            // 验签和解析请求体
            Notification notification = handler.parse(request);
            JSONObject res = JSON.parseObject(notification.getDecryptData());
            //做一些操作
            JSONObject attach = res.getJSONObject("attach");
        } catch (Exception e) {
            log.error("微信支付回调失败", e);
        }
    }
}
