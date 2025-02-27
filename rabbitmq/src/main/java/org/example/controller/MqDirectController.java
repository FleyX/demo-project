package org.example.controller;

import cn.hutool.core.util.RandomUtil;
import org.example.config.DirectRabbitConfig;
import org.example.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direct")
public class MqDirectController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/one")
    public void sendOne(){
        this.rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECT_EXCHANGE,"direct.one", RandomUtil.randomString(10));
    }

    @GetMapping("/two")
    public void sendTwo(){
        this.rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECT_EXCHANGE,"direct.two",System.currentTimeMillis());
    }

}
