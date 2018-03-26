package com.chen.ssm.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义的异常处理器
 * @author JD
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		CustomException customException;
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else{
			customException = new CustomException("未知错误");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error_message", customException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
