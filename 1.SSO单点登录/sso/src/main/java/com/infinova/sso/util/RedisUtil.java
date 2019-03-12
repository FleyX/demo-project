package com.infinova.sso.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    public static RedisTemplate<String, String> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 设置键值对，使用默认过期时间
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE_TIME);
    }

    /**
     * 设置键值对，指定过期时间
     *
     * @param key        key
     * @param value      value
     * @param expireTime 过期时间
     */
    public static void set(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
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
