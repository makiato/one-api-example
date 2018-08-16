package com.zettamachine.oneapi.example.entity.common;

public class ErrorObject {
	String code;
	String message;
	
	public ErrorObject(String code, String message) {
		setCode(code);
		setMessage(message);
	}
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
