package com.fanxb.redismq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义消费者注解
 * Created with IntelliJ IDEA
 * Created By Fxb
 * Date: 2020/3/26
 * Time: 15:26
 * @author fanxb
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MqConsumer {

    /**
     * 队列主题
     */
    String topic() default "default_es_topic";
}
