package org.example.listener;

import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.example.config.DirectRabbitConfig;
import org.example.entity.mq.MqMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {
    public static final String QUEUE = "autoCreateQueue";
    public static final String EXCHANGE = "autoCreateExchange";
    public static final String KEY = "autoCreate";

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QUEUE, durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = EXCHANGE, type = ExchangeTypes.TOPIC),
            key = {KEY}
    ), concurrency = "4", ackMode = "MANUAL")
    public void autoCreateQueue(Channel channel, Message message, @Payload MqMessage body) throws Exception {
        MessageProperties properties = message.getMessageProperties();
        log.info("收到消息:{},{},{},{}", properties.getDeliveryTag(), properties.getHeader("unique-id"), properties.getReceivedRoutingKey(), new ObjectMapper().writeValueAsString(body));
        channel.basicAck(properties.getDeliveryTag(), false);
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_ONE, ackMode = "AUTO")
    public void directOneQueue(Message message, @Payload String body) {
        log.info("directOne收到消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_ONE_COPY, ackMode = "AUTO")
    public void directOneCopyQueue(Message message, @Payload String body) {
        log.info("directOneCopy收到消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
    }

    @RabbitListener(queues = DirectRabbitConfig.DIRECT_TWO, ackMode = "AUTO")
    public void directTwoQueue(Message message, @Payload String body) {
        log.info("directTwo收到消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout1Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)
    ), ackMode = "AUTO")
    public void fanout1(Message message, @Payload String body) {
        log.info("fanout1收到广播消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout1Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)
    ), ackMode = "AUTO")
    public void fanout11(Message message, @Payload String body) {
        log.info("fanout11收到广播消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
    }

    /**
     * 测试AUTO ack
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout2Queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "fanoutExchange", type = ExchangeTypes.FANOUT)
    ), ackMode = "AUTO")
    public void fanout2(Message message, @Payload String body) {
        log.info("fanout2收到广播消息：{},{}", message.getMessageProperties().getDeliveryTag(), body);
        if (RandomUtil.randomInt() % 2 == 1) {
            throw new RuntimeException("error");
        }
    }

}
