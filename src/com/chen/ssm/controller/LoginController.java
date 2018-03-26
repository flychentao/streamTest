package com.chen.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc与json交互
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login.action")
	public String login(HttpSession session,String username){
		
		session.setAttribute("username", username); // 将登录信息保存到了session中
		
		return "redirect:items/queryItems.action";
	}
}
