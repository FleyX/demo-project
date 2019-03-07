package com.example.sysa.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.sysa.entity.ReturnEntity;
import com.example.sysa.entity.UserContext;
import com.example.sysa.util.HttpClient;
import com.example.sysa.util.UserContextHolder;
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

    public static final Map<String, Long> tokenMap = new ConcurrentHashMap<>();
    /**
     * 10s内认为报错在tokenMap中的token有效，避免频繁请求认证中心验证token有效性
     */
    private static final int EXPIRE_TIME = 10 * 1000;

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
        boolean isOk = false;
        String token = "";
        try {
            //如果token未缓存或距离上次检查有效性超过1分钟，向认证中心请求检查有效性
            token = httpServletRequest.getParameter("token");
            Long lastCheckTime = tokenMap.get(token);
            if (lastCheckTime == null || System.currentTimeMillis() - lastCheckTime > EXPIRE_TIME) {
                JSONObject object = HttpClient.get("http://localhost:8080/checkToken?token=" + token);
                if (object.getInteger("code") == 1) {
                    isOk = true;
                    tokenMap.put(token, System.currentTimeMillis());
                }
            } else {
                //token有效，且未过期
                isOk = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isOk) {
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
}
