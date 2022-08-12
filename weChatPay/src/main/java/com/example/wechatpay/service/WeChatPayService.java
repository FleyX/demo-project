package com.example.wechatpay.service;


import com.example.wechatpay.entity.PayHistoryPo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface WeChatPayService {

    /**
     * 微信支付预定单生成
     *
     * @param body body
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author fanxb
     * date 2022/7/25 21:50
     */
    Map<String, String> pay(PayHistoryPo body);

    /**
     * 微信支付回调处理
     *
     * @author fanxb
     * date 2022/7/25 22:27
     */
    void notify(HttpServletRequest servletRequest);
}