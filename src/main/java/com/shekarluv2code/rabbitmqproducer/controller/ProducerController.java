package com.shekarluv2code.rabbitmqproducer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shekarluv2code.rabbitmqproducer.entity.Order;
import com.shekarluv2code.rabbitmqproducer.producer.MessageProducer;

@RestController
public class ProducerController {
	
	@Autowired
	private MessageProducer messageProducer;
	
	@RequestMapping("/order")
	public String producer(@RequestParam(value="Order") String orderJSON) throws IOException  {
		messageProducer.sendMessage(orderJSON);
		return orderJSON;
	}

}
