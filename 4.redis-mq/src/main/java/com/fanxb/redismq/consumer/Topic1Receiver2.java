package com.fanxb.redismq.consumer;

import com.fanxb.redismq.annotation.MqConsumer;
import com.fanxb.redismq.entity.RedisConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA
 * Created By Fxb
 * Date: 4/15/20
 * Time: 4:10 AM
 */
@MqConsumer(topic = "topic1")
class Topic1Receiver2 implements RedisConsumer {
    private static final Logger log = LoggerFactory.getLogger(Topic1Receiver2.class);

    @Override
    public void deal(String message) {
        log.info("topic1收到信息:" + message);
    }
}
