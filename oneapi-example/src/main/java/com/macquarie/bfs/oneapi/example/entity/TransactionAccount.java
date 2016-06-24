package com.macquarie.bfs.oneapi.example.entity;

import com.macquarie.bfs.oneapi.example.entity.model.AbstractAccount;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;

public class TransactionAccount extends AbstractAccount implements Entity {

	public TransactionAccount(String id, String accountStatus) {
		super(id, "TransactionAccount", accountStatus);
	}

}
