package com.fanxb.redismq.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis-mq 工具类
 * Created with IntelliJ IDEA
 * Created By Fxb
 * Date: 4/12/20
 * Time: 11:36 PM
 */
@Component
public class RedisMqUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public StringRedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 功能描述:
     *
     * @param topic 队列名
     * @param obj  数据载体
     * @author fanxb
     * @date 4/13/20 1:40 AM
     */
    public void addToMq(String topic, Object obj) {
        String str = obj instanceof String ? (String) obj : JSON.toJSONString(obj);
        redisTemplate.opsForList().leftPush(topic, str);
    }
}
