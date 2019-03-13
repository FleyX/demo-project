package com.example.sysa.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.sysa.entity.ReturnEntity;
import com.example.sysa.entity.UserContext;
import com.example.sysa.util.HttpClient;
import com.example.sysa.util.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/1 10:35
 */
@Component
@WebFilter(urlPatterns = "/**", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${sso_server}")
    private String serverHost;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (httpServletRequest.getRequestURI().startsWith("/static")) {
            UserContextHolder.remove();
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = httpServletRequest.getParameter("token");
        if (this.check(token)) {
            //token和用户id保存到userContextholder
            String str = new String(Base64Utils.decodeFromString(token.split("\\.")[1]));
            UserContext context = new UserContext(JSON.parseObject(str).getString("name"), token);
            UserContextHolder.set(context);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSON.toJSONString(new ReturnEntity(-1, "未登录", null)));
        }
    }

    private boolean check(String jwt) {
        try {
            if (jwt == null || jwt.trim().length() == 0) {
                return false;
            }
            JSONObject object = HttpClient.get(serverHost + "/checkJwt?token=" + jwt);
            return object.getInteger("code") == 1;
        } catch (Exception e) {
            logger.error("向认证中心请求失败", e);
            return false;
        }

    }
}
