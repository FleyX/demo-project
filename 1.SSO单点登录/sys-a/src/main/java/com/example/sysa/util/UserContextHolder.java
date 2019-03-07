package com.example.sysa.util;


import com.example.sysa.entity.UserContext;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/1 14:26
 */
public class UserContextHolder {

    private static final ThreadLocal<UserContext> USER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    public static UserContext get() {
        return USER_CONTEXT_THREAD_LOCAL.get();
    }

    public static void set(UserContext context) {
        USER_CONTEXT_THREAD_LOCAL.set(context);
    }

    public static void remove() {
        USER_CONTEXT_THREAD_LOCAL.remove();
    }

}
