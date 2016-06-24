package com.macquarie.bfs.oneapi.example.entity.model;

public abstract class AbstractEntity {
	String type;
	String id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
