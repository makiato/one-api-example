package com.macquarie.bfs.oneapi.example.entity.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.macquarie.bfs.oneapi.example.entity.common.ErrorObject;
import com.macquarie.bfs.oneapi.example.entity.common.MetaObject;

public interface Response {
	void set(HttpServletRequest request);
	
	void addErrorObject(ErrorObject error);

	void setErrors(List<ErrorObject> errors);

	List<ErrorObject> getErrors();

	void addEntityToData(Entity entity);

	void setData(List<Entity> entities);
	
	void setData(Entity entity);

	List<Entity> getData();

	MetaObject getMeta();

	void setMeta(MetaObject meta);

}