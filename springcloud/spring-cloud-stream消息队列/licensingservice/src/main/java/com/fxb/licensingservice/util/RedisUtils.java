package com.fxb.licensingservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/21 15:05
 */
@Component
@SuppressWarnings("all")
public class RedisUtils {

    public static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisUtils.redisTemplate = redisTemplate;
    }

    public static boolean setObj(String key,Object value){
        return setObj(key,value,0);
    }

    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/2/21 15:21
     * @param key 键
     * @param value 值
     * @param time 过期时间,单位ms
     * @return boolean 是否成功
     */
    public static boolean setObj(String key,Object value,long time){
        try{
            if(time<=0){
                redisTemplate.opsForValue().set(key,value);
            }else{
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.MILLISECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Object get(String key){
        if(key==null){
            return null;
        }
        try{
            Object obj = redisTemplate.opsForValue().get(key);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void del(String... key){
        if(key!=null && key.length>0){
            redisTemplate.delete(CollectionUtils.arrayToList(key));
        }
    }
}
