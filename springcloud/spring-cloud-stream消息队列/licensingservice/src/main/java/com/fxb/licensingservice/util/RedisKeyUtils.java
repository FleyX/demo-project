package com.fxb.licensingservice.util;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/22 10:36
 */
public class RedisKeyUtils {

    private static final String  ORG_CACHE_PREFIX = "orgCache_";

    public static String getOrgCacheKey(String orgId){
        return ORG_CACHE_PREFIX+orgId;
    }
}
