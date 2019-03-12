package com.infinova.sso.entity;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/7 16:46
 */
public class JwtInfo {
    private String secret;
    private long lastRefreshTime;

    public JwtInfo(String secret, long lastRefreshTime) {
        this.secret = secret;
        this.lastRefreshTime = lastRefreshTime;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
