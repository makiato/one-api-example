package com.macquarie.bfs.oneapi.example.entity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties({"basePath"})
@JsonInclude(Include.NON_EMPTY)
public abstract class AbstractEntity {
	String resource;
	String id;
	String self;
	String basePath;
	String entityType;
	List<String> parentEntityTypes;
	
	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public List<String> getParentEntityTypes() {
		return parentEntityTypes;
	}

	public void setParentEntityTypes(List<String> parentEntityTypes) {
		this.parentEntityTypes = parentEntityTypes;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
