package com.fxb.licensingservice.filters;

import com.fxb.licensingservice.Entity.UserContext;
import com.fxb.licensingservice.util.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/21 16:23
 */
@Component
@WebFilter(urlPatterns = "/*", filterName="userContextFilter")
public class UserContextFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(UserContextHolder.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String id = request.getHeader(UserContext.ID_HEADER_KEY);
        if (id == null || id.trim().length() == 0) {
            UserContextHolder.remove();
        } else {
            UserContext context = new UserContext();
            context.id = id;
            UserContextHolder.setContext(context);
            logger.info("当前入栈id:{}", id);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
