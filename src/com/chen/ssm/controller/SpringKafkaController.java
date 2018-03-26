package com.chen.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringKafkaController {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@ResponseBody
	@RequestMapping(value="/testKafka.action")
	public void signIn(HttpServletRequest request,HttpServletResponse resp) {
		kafkaTemplate.sendDefault("123456");
	}
}
