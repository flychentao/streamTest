package com.chen.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.ssm.mapper.ConsumerMessageMapper;

@Service
public class SpringKafkaConsumerService {

	@Autowired
	private ConsumerMessageMapper consumerMessageMapper;
	public void saveMessage(String msg){
		try {
			consumerMessageMapper.saveMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
