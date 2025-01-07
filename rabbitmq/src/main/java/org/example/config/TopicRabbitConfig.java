package org.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class TopicRabbitConfig {

	public final static String TOPIC_ONE = "topic.one";
	public final static String TOPIC_TWO = "topic.two";
	public final static String TOPIC_EXCHANGE = "topicExchange1";

	@Bean
	public Queue queueOne(){
		return new Queue(TOPIC_ONE);
	}

	@Bean
	public Queue queueTwo(){
		return new Queue(TOPIC_TWO);
	}

	@Bean
	TopicExchange topicExchange(){
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	Binding bindingExchangeOne(Queue queueOne, TopicExchange topicExchange){
		return BindingBuilder.bind(queueOne).to(topicExchange).with("topic.one");
	}

	@Bean
	Binding bindingExchangeTwo(Queue queueTwo, TopicExchange topicExchange){
		//# 表示零个或多个词
		//* 表示一个词
		return BindingBuilder.bind(queueTwo).to(topicExchange).with("topic.#");
	}

}