package com.chen.listener;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

public class SpringKafkaProducerListener implements ProducerListener<String, String> {

	@Override
	public boolean isInterestedInSuccess() {
		return true;
	}

	@Override
	public void onError(String topic, Integer partition, String key, String value, Exception e) {
		System.out.println("发送消息失败：主题"+topic+"消息："+value+"异常："+e.getLocalizedMessage());
	}

	@Override
	public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
		System.out.println("消息发送成功：主题："+topic+",分区："+recordMetadata.partition()+",时间"+recordMetadata.timestamp()
		+",信息："+value);
	}

	
	
	
	

}
