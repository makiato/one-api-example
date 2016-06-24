package com.macquarie.bfs.oneapi.example.entity.common;

import java.util.ArrayList;
import java.util.List;

import com.macquarie.bfs.oneapi.example.entity.model.AbstractResponse;
import com.macquarie.bfs.oneapi.example.entity.model.Response;

public class ErrorResponse extends AbstractResponse implements Response {
	List<ErrorObject> errors;

	public void addErrorObject(ErrorObject error) {
		getErrors().add(error);
	}
	
	public void setErrors(List<ErrorObject> errors) {
		getErrors().clear();
		getErrors().addAll(errors);
	}
	
	public List<ErrorObject> getErrors() {
		if(errors == null) errors = new ArrayList<ErrorObject>();
		return errors;
	}
}
