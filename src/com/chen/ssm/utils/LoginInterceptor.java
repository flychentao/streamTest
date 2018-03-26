package com.chen.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 作用：执行任何方法之前执行该方法
	 * 
	 * 使用场景：校验工作、加载权限信息等  
	 * 
	 * return：true：放行   false：不放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 1、如果是登录操作，直接放行
		String uri = request.getRequestURI();
		if(uri.lastIndexOf("login.action")>0){ // 登录操作，放行
			return true;
		}
		if(uri.lastIndexOf("action")>0){ // 登录操作，放行
			return true;
		}
		// 2、非登录操作   有用户：放行  没有用户：踢回登录页面
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username!=null && !"".equals(username)){ //   有用户：放行
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	/**
	 * 作用：执行完Controller方法后执行该方法
	 * 
	 * 使用场景：更改mv中的内容
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 作用：执行完所有的方法后执行该方法
	 * 
	 * 使用场景：释放资源操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
