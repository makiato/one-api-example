package com.macquarie.bfs.oneapi.example.entity.common;

import java.util.UUID;

public class MetaObject {
	String requestId;
	
	public MetaObject() {
		requestId = UUID.randomUUID().toString();
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
