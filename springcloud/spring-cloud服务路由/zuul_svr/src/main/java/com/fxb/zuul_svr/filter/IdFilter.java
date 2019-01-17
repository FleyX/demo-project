package com.fxb.zuul_svr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/1/8 18:48
 */
@Component
public class IdFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdFilter.class);

    /**
     * 返回过滤器类型 ；pre:前置过滤器。post：后置过滤器。routing:路由过滤器。error：错误过滤器
     */
    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String id = ctx.getRequest().getHeader("id");
        //如果request找不到，再到zuul的方法中找id.request不允许直接修改response中的header，
        // 所以为了让后续的过滤器能够获取到id才有下面的语法
        if(id==null){
            id = ctx.getZuulRequestHeaders().get("id");
        }

        if (id == null) {
            id = UUID.randomUUID().toString();
            LOGGER.info("{} 无id，生成id:{}",ctx.getRequest().getRequestURI(), id);
            ctx.addZuulRequestHeader("id", id);
        } else {
            LOGGER.info("{}存在id：{}", ctx.getRequest().getRequestURI(), id);
        }
        return null;
    }
}
