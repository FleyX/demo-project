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
@RequestMapping("/fanout")
public class MqFanoutController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/add")
    public void add() {
        this.rabbitTemplate.convertAndSend("fanoutExchange","", RandomUtil.randomString(10));
    }
}
