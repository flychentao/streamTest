package com.chen.ssm.utils.exception;

@SuppressWarnings("serial")
public class CustomException extends Exception{

	private String message; // 异常信息
	
	public CustomException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
