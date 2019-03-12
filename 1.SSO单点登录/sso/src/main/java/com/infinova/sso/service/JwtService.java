package com.infinova.sso.service;

import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.JWT;
import com.infinova.sso.entity.JwtInfo;
import com.infinova.sso.entity.User;
import com.infinova.sso.exception.CustomException;
import com.infinova.sso.util.HttpUtil;
import com.infinova.sso.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/4 18:17
 */
@Service
@EnableScheduling
public class JwtService {

    public static final String JWT_KEY = "jwt_token";

    private Logger logger = LoggerFactory.getLogger(JwtService.class);

    /**
     * 存储jwt与secret对应关系
     */
    private static Map<String, JwtInfo> jwtMap = new ConcurrentHashMap<>();

    /**
     * jwt token超时时间，单位s
     */
    private static final int TIME_OUT = 60 * 60;
    /**
     * 在此时间段内，一个jwt不能重复刷新
     */
    private static final int REFRESH_INTERVAL = 5 * 60 * 1000;

    /**
     * Description:登录获取token
     *
     * @param user user
     * @return java.lang.String
     * @author fanxb
     * @date 2019/3/4 18:45
     */
    public String login(User user) {
        //进行登录校验
        try {
            if (user.getName().equalsIgnoreCase(user.getPassword())) {
                String token = this.generateNewJwt(user.getName());
                setCookie(token, TIME_OUT);
                return token;
            } else {
                logger.info("账号密码错误:{}{}", user.getName(), user.getPassword());
                throw new CustomException("账号密码错误");
            }
        } catch (Exception e) {
            logger.info("账号密码错误:{},{}", user.getName(), user.getPassword());
            throw new CustomException("账号密码错误");
        }
    }

    /**
     * Description:刷新token
     *
     * @return java.lang.String
     * @author fanxb
     * @date 2019/3/5 11:06
     */
    public String refreshJwt(String token) {
        try {
            JwtInfo info = jwtMap.get(token);
            Long nowTime = System.currentTimeMillis();
            if (nowTime - info.getLastRefreshTime() < REFRESH_INTERVAL) {
                throw new CustomException("token刷新间隔过短");
            }
            info.setLastRefreshTime(nowTime);
            String id = JwtUtil.decode(token, info.getSecret()).get("loginId").asString();
            String newToken = generateNewJwt(id);
            setCookie(newToken, TIME_OUT);
            return newToken;
        } catch (Exception e) {
            throw new CustomException(e, "token校验失败");
        }
    }

    /**
     * Description: 生成新的jwt,并放入jwtMap中
     *
     * @return java.lang.String
     * @author fanxb
     * @date 2019/3/5 10:44
     */
    private String generateNewJwt(String name) {
        String secret = UUID.randomUUID().toString().replaceAll("-", "");
        String token = JwtUtil.encode(name, secret, TIME_OUT);
        jwtMap.put(token, new JwtInfo(secret, 0));
        return token;
    }

    /**
     * Description:检查jwt有效性,返回失效jwt
     *
     * @return List<String> 失效jwt列表
     * @author fanxb
     * @date 2019/3/4 18:47
     */
    public List<String> checkJwt(JSONArray tokens) {
        List<String> res = new ArrayList<>();
        tokens.forEach(item -> {
            String jwt = (String) item;
            try {
                String secret = jwtMap.get(jwt).getSecret();
                JwtUtil.decode(jwt, secret);
            } catch (Exception e) {
                e.printStackTrace();
                res.add(jwt);
            }
        });
        return res;
    }

    /**
     * Description: 使该jwt失效
     *
     * @author fanxb
     * @date 2019/3/4 19:58
     */
    public void inValid(String jwt) {
        jwtMap.remove(jwt);
        setCookie("", 0);
    }

    /**
     * Description:定时检查过期的jwt，并从map中删除
     *
     * @author fanxb
     * @date 2019/3/5 18:16
     */
    @Scheduled(fixedRate = 10 * 1000)
    private void cleanJwtMap() {
        Date now = new Date();
        Set<String> keys = jwtMap.keySet();
        keys.forEach(item -> {
            if (now.getTime() > JWT.decode(item).getExpiresAt().getTime()) {
                jwtMap.remove(item);
                logger.info("清理掉了：{}", item);
            }
        });
    }

    /**
     * Description: 写入jwt token到cookie
     *
     * @param token  token
     * @param maxAge 失效时间 单位s
     * @return void
     * @author fanxb
     * @date 2019/3/5 18:43
     */
    private void setCookie(String token, int maxAge) {
        Cookie cookie = new Cookie(JWT_KEY, token);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        HttpUtil.getResponse().addCookie(cookie);
    }


}
