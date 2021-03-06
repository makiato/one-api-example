package com.zettamachine.oneapi.example.entity;

import java.util.Arrays;
import java.util.Collections;

import com.zettamachine.oneapi.example.entity.model.AbstractAccount;
import com.zettamachine.oneapi.example.entity.model.Entity;

public class TransactionAccount extends AbstractAccount implements Entity {

	public TransactionAccount(String id, String accountStatus, String entityType) {
		super(id, "account", accountStatus, entityType, Arrays.asList("Transaction Account", "Account"));
	}

}
