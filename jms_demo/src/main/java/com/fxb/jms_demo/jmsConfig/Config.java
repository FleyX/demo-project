package com.fxb.jms_demo.jmsConfig;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-20
 */
@Configuration
public class Config {
    @Bean(name = "queue2")
    public Queue queue2(){
        return new ActiveMQQueue("active.queue2");
    }

    @Bean(name = "queue1")
    public Queue queue1(){
        return new ActiveMQQueue("active.queue1");
    }
}
