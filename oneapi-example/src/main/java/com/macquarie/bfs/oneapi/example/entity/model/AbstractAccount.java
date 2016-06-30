package com.macquarie.bfs.oneapi.example.entity.model;

import java.util.List;

public abstract class AbstractAccount extends AbstractEntity {
	String accountStatus;
	
	public AbstractAccount(String id, String type, String accountStatus, String entityType, List<String> parentTypes) {
		setId(id);
		setType(type);
		setAccountStatus(accountStatus);
		setEntityType(entityType);
		setParentEntityTypes(parentTypes);
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
