package com.infinova.sso.service;

import com.infinova.sso.entity.User;
import com.infinova.sso.exception.CustomException;
import com.infinova.sso.util.JwtUtil;
import com.infinova.sso.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.*;

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
     * jwt token超时时间，单位ms
     */
    private static int expireTime;

    @Value("${jwt_expire_time}")
    public void setExpireTime(int expireTime) {
        JwtService.expireTime = expireTime * 60 * 1000;
    }

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
                return this.generateNewJwt(user.getName());
            } else {
                logger.info("账号密码错误:{}{}", user.getName(), user.getPassword());
                throw new CustomException("账号密码错误");
            }
        } catch (Exception e) {
            logger.info("账号密码错误:{},{}", user.getName(), user.getPassword());
            throw new CustomException(e, "账号密码错误");
        }
    }


    /**
     * Description: 生成新的jwt,并放入jwtMap中
     *
     * @return java.lang.String
     * @author fanxb
     * date 2019/3/5 10:44
     */
    private String generateNewJwt(String name) {
        String secret = UUID.randomUUID().toString().replaceAll("-", "");
        String token = JwtUtil.encode(name, secret, expireTime);
        RedisUtil.set(token, secret, expireTime);
        return token;
    }

    /**
     * Description:检查jwt有效性
     *
     * @return Boolean
     * @author fanxb
     * @date 2019/3/4 18:47
     */
    public Boolean checkJwt(String jwt) {
        try {
            String secret = RedisUtil.redisTemplate.opsForValue().get(jwt);
            JwtUtil.decode(jwt, secret);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Description: 使该jwt失效
     *
     * @author fanxb
     * @date 2019/3/4 19:58
     */
    public void inValid(String jwt) {
        RedisUtil.delete(jwt);
    }

}
