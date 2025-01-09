package org.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DirectRabbitConfig {

	public final static String DIRECT_ONE = "direct.one";
	public final static String DIRECT_TWO= "direct.two";
	public final static String DIRECT_ONE_COPY = "direct.one.copy";
	public final static String DIRECT_EXCHANGE= "directExchange1";

	@Bean
	public Queue directQueueOne(){
		return new Queue(DIRECT_ONE);
	}

	@Bean
	public Queue directQueueOneCopy() {
		return new Queue(DIRECT_ONE_COPY);
	}

	@Bean
	public Queue directQueueTwo(){
		return new Queue(DIRECT_TWO);
	}

	@Bean
	DirectExchange directExchange(){
		return new DirectExchange(DIRECT_EXCHANGE);
	}

	@Bean
	Binding bindingDirectExchangeOne(Queue directQueueOne, DirectExchange directExchange){
		return BindingBuilder.bind(directQueueOne).to(directExchange).with("direct.one");
	}

	@Bean
	Binding bindingDirectExchangeOneCopy(Queue directQueueOneCopy, DirectExchange directExchange){
		return BindingBuilder.bind(directQueueOneCopy).to(directExchange).with("direct.one");
	}

	@Bean
	Binding bindingDirectExchangeTwo(Queue directQueueTwo, DirectExchange directExchange){
		//# 表示零个或多个词
		//* 表示一个词
		return BindingBuilder.bind(directQueueTwo).to(directExchange).with("direct.two");
	}

}