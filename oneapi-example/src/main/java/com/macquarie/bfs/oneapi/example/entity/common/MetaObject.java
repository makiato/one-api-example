package com.macquarie.bfs.oneapi.example.entity.common;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MetaObject {
	String requestId;
	DataSetObject dataSet;
	
	public MetaObject() {
		requestId = UUID.randomUUID().toString();
	}

	
	public DataSetObject getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSetObject dataSet) {
		this.dataSet = dataSet;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
