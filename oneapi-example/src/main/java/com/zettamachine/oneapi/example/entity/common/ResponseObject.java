package com.zettamachine.oneapi.example.entity.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.zettamachine.oneapi.example.entity.model.Entity;
import com.zettamachine.oneapi.example.entity.model.Response;

@JsonInclude(Include.NON_EMPTY)
public class ResponseObject implements Response {
	MetaObject meta = new MetaObject();
	List<Entity> data;
	List<ErrorObject> errors;
	HttpServletRequest request;

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
	
	public void addEntityToData(Entity entity) {
		getData().add(entity);
	}
	
	public void setData(List<Entity> entities) {
		getData().clear();
		getData().addAll(entities);
	}
	
	public List<Entity> getData() {
		if(data == null) data = new ArrayList<Entity>();
		return data;
	}

	public MetaObject getMeta() {
		return meta;
	}

	public void setMeta(MetaObject meta) {
		this.meta = meta;
	}

	public void setData(Entity entity) {
		getData().clear();
		getData().add(entity);
	}

	public void set(HttpServletRequest request) {
		this.request = request;
	}
}
