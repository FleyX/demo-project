package com.fanxb.redismq.entity;

/**
 * redis消费者类
 * Created By Fxb
 * Date: 2020/3/28
 * Time: 22:41
 */
public interface RedisConsumer {

    /**
     * 功能描述: 消费方法，消费者类必须继承此方法
     *
     * @param message 数据载体
     * @author 123
     * @date 2020/3/28 22:41
     */
    void deal(String message);
}
