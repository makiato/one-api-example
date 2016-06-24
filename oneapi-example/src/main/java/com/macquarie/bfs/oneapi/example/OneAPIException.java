package com.macquarie.bfs.oneapi.example;

import com.macquarie.bfs.oneapi.example.entity.common.ErrorObject;

public class OneAPIException extends Exception {

	ErrorObject error;
	int httpCode = 200;
	
	private static final long serialVersionUID = 1L;
	
	public OneAPIException(ErrorObject error) {
		setError(error);
	}
	
	public OneAPIException(ErrorObject error, int httpCode) {
		setError(error);
		setHttpCode(httpCode);
	}

	public ErrorObject getError() {
		return error;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public void setError(ErrorObject error) {
		this.error = error;
	}

}
