package com.fxb.zuul_svr.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/1/8 18:48
 */
@Component
public class RouteFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteFilter.class);

    /**
     * 返回过滤器类型 ；pre:前置过滤器。post：后置过滤器。routing:路由过滤器。error：错误过滤器
     */
    @Override
    public String filterType() {
        return "routing";
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
        /**
         * 下面只写出实现思路，真的完全实现下面的功能，代码量较大，可以参考spring 微服务实战中的实现<a href="https://github.com/carnellj/spmia-chapter6/blob/master/zuulsvr/src/main/java/com/thoughtmechanix/zuulsvr/filters/SpecialRoutesFilter.java">点击跳转</a>
         *
         * 1.获取当前路径
         * 2.判断是否需要进行特殊路由
         * 3.如需要进行特殊路由，在此发起http请求
         * 3.将响应写到response返回给调用者
         */
        return null;
    }
}
