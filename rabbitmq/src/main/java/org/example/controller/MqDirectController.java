package org.example.controller;

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
    @GetMapping("/simple")
    public void sendSimple(){
        this.rabbitTemplate.convertAndSend("topic.one","abc");
    }

    @GetMapping("/one")
    public void sendOne(){
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.one","abc");
    }

    @GetMapping("/two")
    public void sendTwo(){
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.two",System.currentTimeMillis());
    }

}
