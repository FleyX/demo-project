package org.example.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.mq.MqMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoCreateListener {
    public static final String QUEUE = "autoCreateQueue";
    public static final String EXCHANGE = "autoCreateExchange";
    public static final String KEY = "autoCreate";

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QUEUE, durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = EXCHANGE, type = ExchangeTypes.TOPIC),
            key = {KEY}
    ), concurrency = "4", ackMode = "MANUAL")
    public void process(Channel channel, Message message, @Payload MqMessage body ) throws Exception {
        MessageProperties properties = message.getMessageProperties();
        log.info("收到消息:{},{},{},{}", properties.getDeliveryTag(), properties.getHeader("unique-id"), properties.getReceivedRoutingKey(), new ObjectMapper().writeValueAsString(body));
        channel.basicAck(properties.getDeliveryTag(), false);
    }
}
