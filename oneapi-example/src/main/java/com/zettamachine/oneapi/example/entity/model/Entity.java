package com.zettamachine.oneapi.example.entity.model;

import java.util.List;

public interface Entity {
	public String getResource();
	public void setResource(String resource);
	public String getId();
	public void setId(String id);
	public String getEntityType();
	public void setEntityType(String entityType);
	public List<String> getParentEntityTypes();
	public void setParentEntityTypes(List<String> parentEntityTypes);
}
