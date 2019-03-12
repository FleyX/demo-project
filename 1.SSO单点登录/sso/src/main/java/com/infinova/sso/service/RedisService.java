package com.infinova.sso.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.infinova.sso.entity.User;

/**
 * 类功能简述：使用此类演示一些redis的缓存操作
 * 加上CacheConfig注解可为当前泪下类下所有redis缓存做配置，比如cacheNames给类下所有的key加上前缀
 *
 * @author fanxb
 * @date 2019/3/8 13:53
 */
@CacheConfig(cacheNames = "redis_test")
@Service
public class RedisService {

    /**
     * 缓存时间，首次查询后会缓存结果,key中的值可使用表达式计算
     *
     * @return long
     */
    @Cacheable(key = "'currentTime'")
    public long getTime() {
        return System.currentTimeMillis();
    }

    @CacheEvict(key = "'currentTime'")
    public void deleteTime() {

    }

    @Cacheable(key = "'currentTime'+#id")
    public Long getTime(String id) {
        return null;
    }

    /**
     * 一般用于更新查插入操作，每次都会请求db
     */
    @CachePut(key = "'currentTime'+#id")
    public long updateTime(String id) {
        return System.currentTimeMillis();
    }

    /**
     * 清除缓存
     *
     * @param id id
     */
    @CacheEvict(key = "'currentTime'+#id", allEntries = false)
    public void deleteTime(String id) {
    }

    @Caching(put = {@CachePut(value = "user", key = "'name_'+#user.name"),
            @CachePut(value = "user", key = "'pass_'+#user.password")})
    public User testCaching(User user) {
        return user;
    }

}
