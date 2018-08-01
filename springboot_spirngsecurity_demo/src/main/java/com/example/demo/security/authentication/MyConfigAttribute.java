package com.example.demo.security.authentication;

import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义ConfigAttribute实现
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-19
 */
public class MyConfigAttribute implements ConfigAttribute {
    private HttpServletRequest httpServletRequest;
    private MyGrantedAuthority myGrantedAuthority;

    public MyConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public MyConfigAttribute(HttpServletRequest httpServletRequest, MyGrantedAuthority myGrantedAuthority) {
        this.httpServletRequest = httpServletRequest;
        this.myGrantedAuthority = myGrantedAuthority;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    @Override
    public String getAttribute() {
        return myGrantedAuthority.getUrl();
    }

    public MyGrantedAuthority getMyGrantedAuthority() {
        return myGrantedAuthority;
    }
}
