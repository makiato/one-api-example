package com.macquarie.bfs.oneapi.example.entity.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;
import com.macquarie.bfs.oneapi.example.entity.model.Response;

@JsonInclude(Include.NON_EMPTY)
public class ResponseObject implements Response {
	MetaObject meta = new MetaObject();
	List<Entity> data;
	List<ErrorObject> errors;
	HttpServletRequest request;

	@Override
	public void addErrorObject(ErrorObject error) {
		getErrors().add(error);
	}

	@Override
	public void setErrors(List<ErrorObject> errors) {
		getErrors().clear();
		getErrors().addAll(errors);
	}
	
	@Override
	public List<ErrorObject> getErrors() {
		if(errors == null) errors = new ArrayList<ErrorObject>();
		return errors;
	}
	
	@Override
	public void addEntityToData(Entity entity) {
		getData().add(entity);
	}
	
	@Override
	public void setData(List<Entity> entities) {
		getData().clear();
		getData().addAll(entities);
	}
	
	@Override
	public List<Entity> getData() {
		if(data == null) data = new ArrayList<Entity>();
		return data;
	}

	@Override
	public MetaObject getMeta() {
		return meta;
	}

	@Override
	public void setMeta(MetaObject meta) {
		this.meta = meta;
	}

	@Override
	public void setData(Entity entity) {
		getData().clear();
		getData().add(entity);
	}

	@Override
	public void set(HttpServletRequest request) {
		this.request = request;
	}
}
