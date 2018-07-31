package com.fxb.jms_demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: 模拟消息队列接受者
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-20
 */
@Component
public class Comsumer {
    //接受消息队列1消息
    @JmsListener(destination = "active.queue1")
    public void readActiveQueue11(String message){
        System.out.println(1+message);
    }

    //接受消息队列1消息
    @JmsListener(destination = "active.queue1")
    public void readActiveQueue12(String message){
        System.out.println(2+message);
    }

    //接受消息队列2消息
    @JmsListener(destination = "active.queue2")
    public void readActiveQueue21(String message){
        System.out.println(1+message);
    }

    //接受消息队列2消息
    @JmsListener(destination = "active.queue2")
    public void readActiveQueue22(String message){
        System.out.println(2+message);
    }
}
