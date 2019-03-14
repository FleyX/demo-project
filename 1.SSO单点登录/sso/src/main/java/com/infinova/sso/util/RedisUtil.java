package com.infinova.sso.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/8 13:26
 */
@Component
public class RedisUtil {
    private static final int DEFAULT_EXPIRE_TIME = 60 * 1000;

    public static StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    @Autowired


    /**
     * 设置键值对，使用默认过期时间
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, String value) {
        set(key, value, DEFAULT_EXPIRE_TIME);
    }

    /**
     * 设置键值对，指定过期时间
     *
     * @param key        key
     * @param value      value
     * @param expireTime 过期时间
     */
    public static void set(String key, String value, long expireTime) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    /**
     * 删除key
     *
     * @param key key
     */
    public static void delete(String key) {
        redisTemplate.delete(key);
    }
}
