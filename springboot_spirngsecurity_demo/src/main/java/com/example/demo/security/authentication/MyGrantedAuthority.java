package com.example.demo.security.authentication;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义权限类
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-19
 */
public class MyGrantedAuthority implements GrantedAuthority {
    private String method;
    private String url;

    public MyGrantedAuthority(String method, String url) {
        this.method = method;
        this.url = url;
    }

    @Override
    public String getAuthority() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null||getClass()!= obj.getClass()) return false;
        MyGrantedAuthority grantedAuthority = (MyGrantedAuthority)obj;
        if(this.method.equals(grantedAuthority.getMethod())&&this.url.equals(grantedAuthority.getUrl()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = this.method!=null?this.method.hashCode():0;
        result=33*result+(this.url!=null?this.url.hashCode():0);
        return result;
    }

    @Override
    public String toString() {
        return this.method+" : "+this.url;
    }
}
