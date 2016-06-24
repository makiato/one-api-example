package com.macquarie.bfs.oneapi.example.entity.common;

import java.util.ArrayList;
import java.util.List;

import com.macquarie.bfs.oneapi.example.entity.model.AbstractResponse;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;
import com.macquarie.bfs.oneapi.example.entity.model.Response;

public class SuccessResponse extends AbstractResponse implements Response {
	MetaObject meta = new MetaObject();
	List<Entity> data;
	
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
}
