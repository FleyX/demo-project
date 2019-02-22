package com.fxb.licensingservice.util;

import com.fxb.licensingservice.Entity.UserContext;
import org.springframework.util.Assert;

/**
 * 类功能简述：存储每个传入请求id到ThreadLocal中
 *
 * @author fanxb
 * @date 2019/2/21 16:29
 */
public class UserContextHolder {
    private static final ThreadLocal<UserContext> USER_CONTEXT_HOLDER=new ThreadLocal<>();

    public static UserContext getContext(){
        UserContext context = USER_CONTEXT_HOLDER.get();
        if(context==null){
            context = new UserContext();
            USER_CONTEXT_HOLDER.set(context);
        }
        return context;
    }

    public static void setContext(UserContext context){
        Assert.notNull(context,"context不允许为空");
        USER_CONTEXT_HOLDER.set(context);
    }


    public static void remove(){
        USER_CONTEXT_HOLDER.remove();
    }
}
