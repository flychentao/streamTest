package com.chen.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

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
		System.out.println("1---preHandle");
		return true;
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
		System.out.println("3---postHandle");

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
		System.out.println("4---afterCompletion");

	}

}
