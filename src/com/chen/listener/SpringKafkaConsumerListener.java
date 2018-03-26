package com.chen.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import com.chen.kafka.service.SpringApplicationContextService;
import com.chen.kafka.service.SpringKafkaConsumerService;

public class SpringKafkaConsumerListener implements MessageListener<String, String>{

	@Override
	public void onMessage(ConsumerRecord<String, String> recode) {
		SpringKafkaConsumerService springKafkaConsumerService =(SpringKafkaConsumerService) SpringApplicationContextService.getSpringBean("springKafkaConsumerService");
		if(recode != null) {
			springKafkaConsumerService.saveMessage(recode.value());
			System.out.println(recode.topic()+","+recode.partition()+","+recode.timestamp()+","+recode.value());
		}
	}
	
}
