package com.fxb.jms_demo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-20
 */
@RestController
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired()
    @Qualifier("queue2")
    private Queue queue2;

    @Autowired()
    @Qualifier("queue1")
    private Queue queue1;

    @GetMapping("/queue2")
    public void sendMessage1(String message){
            jmsMessagingTemplate.convertAndSend(queue2,"I'm from queue2:"+message);
    }

    @GetMapping("/queue1")
    public void sendMessage2(String message){
        jmsMessagingTemplate.convertAndSend(queue1,"I'm from queue1:"+message);
    }
}
