package org.example.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.example.config.TopicRabbitConfig;
import org.example.entity.mq.MqMessage;
import org.example.listener.Listener;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class MqTopicController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/simple")
    public void sendSimple() {
        this.rabbitTemplate.convertAndSend("topic.one", "abc");
    }

    @GetMapping("/one")
    public void sendOne() {
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.one", "abc");
    }

    @GetMapping("/two")
    public void sendTwo() {
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.two", System.currentTimeMillis());
    }

    @GetMapping("/autoCreateQueue")
    public void autoCreateQueue() {
        //设置唯一id,用于防重复消费
        MessagePostProcessor postProcessor = message -> {
            message.getMessageProperties().setHeader("unique-id", IdUtil.fastSimpleUUID());
            return message;
        };
        this.rabbitTemplate.convertAndSend(Listener.EXCHANGE, Listener.KEY,
                new MqMessage(RandomUtil.randomString(3), RandomUtil.randomString(5)), postProcessor);
    }
}
