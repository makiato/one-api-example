package com.macquarie.bfs.oneapi.example.entity.model;

public abstract class AbstractAccount extends AbstractEntity {
	String accountStatus;
	
	public AbstractAccount(String id, String type, String accountStatus) {
		setId(id);
		setType(type);
		setAccountStatus(accountStatus);
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
