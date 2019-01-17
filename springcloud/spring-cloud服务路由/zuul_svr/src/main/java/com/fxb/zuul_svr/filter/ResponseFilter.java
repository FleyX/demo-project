package com.fxb.zuul_svr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/1/8 18:48
 */
@Component
public class ResponseFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseFilter.class);

    /**
     * 返回过滤器类型 ；pre:前置过滤器。post：后置过滤器。routing:路由过滤器。error：错误过滤器
     */
    @Override
    public String filterType() {
        return "post";
    }

    /**
     * 过滤器执行顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否启动此过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        String id = ctx.getZuulRequestHeaders().get("id");
        ctx.getResponse().addHeader("id", id);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ctx.getResponseDataStream()));
            String response = reader.readLine();
            LOGGER.info("响应为：{}", response);
            //写到输出流中,本来可以由zuul框架来操作，但是我们已经读取了输入流，zuul读不到数据了，所以要手动写响应到response
            ctx.getResponse().setHeader("Content-Type","application/json;charset=utf-8");
            ctx.getResponse().getWriter().write(response);
        } catch (Exception e) {
        }
        return null;
    }
}
