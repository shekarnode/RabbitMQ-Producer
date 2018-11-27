package com.shekarluv2code.rabbitmqproducer.producer;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shekarluv2code.rabbitmqproducer.config.RobbitMqConfig;


@Component
public class MessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String orderJSON) {
		System.out.println(new Date());
		rabbitTemplate.convertAndSend(RobbitMqConfig.ROUTING_KEY, orderJSON);
		System.out.println("Is listner returned :::  " +rabbitTemplate.isReturnListener());
	}
}
