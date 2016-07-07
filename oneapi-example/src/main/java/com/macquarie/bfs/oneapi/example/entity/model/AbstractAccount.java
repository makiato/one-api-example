package com.macquarie.bfs.oneapi.example.entity.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"dateFormat","random"})
public abstract class AbstractAccount extends AbstractEntity {
	String accountStatus;
	SimpleDateFormat dateFormat;
	String lastTransactionDate;
	Random random;
	
	public String getLastTransactionDate() {
		return dateFormat.format((new Date(System.currentTimeMillis() - random.nextInt(10000000))));
	}

	public void setLastTransactionDate(String lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public AbstractAccount(String id, String resource, String accountStatus, String entityType, List<String> parentTypes) {
		setId(id);
		setResource(resource);
		setAccountStatus(accountStatus);
		setEntityType(entityType);
		setParentEntityTypes(parentTypes);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		random = new Random();
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
