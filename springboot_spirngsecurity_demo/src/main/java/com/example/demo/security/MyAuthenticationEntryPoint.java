package com.example.demo.security;

import com.example.demo.error.ErrorCode;
import com.example.demo.util.JsonHelper;
import com.example.demo.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:未登录直接返回401，不进行302跳转
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-18
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private JsonHelper jsonHelper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("未登录:{}",authException.getMessage() );
        ErrorCode code=ErrorCode.UNLOGIN;
        authException.printStackTrace();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jsonHelper.toJson(new Reply(code.getCode(),code.getMess())));
    }
}
