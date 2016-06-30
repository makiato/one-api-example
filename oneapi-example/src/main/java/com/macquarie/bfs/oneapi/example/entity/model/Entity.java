package com.macquarie.bfs.oneapi.example.entity.model;

import java.util.List;

public interface Entity {
	public String getType();
	public void setType(String type);
	public String getId();
	public void setId(String id);
	public String getEntityType();
	public void setEntityType(String entityType);
	public List<String> getParentEntityTypes();
	public void setParentEntityTypes(List<String> parentEntityTypes);
}
