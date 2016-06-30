package com.macquarie.bfs.oneapi.example.entity;

import java.util.Arrays;

import com.macquarie.bfs.oneapi.example.entity.model.AbstractAccount;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;

public class LoanAccount extends AbstractAccount implements Entity {
	String loanDuration;
	
	public LoanAccount(String id, String accountStatus, String entityType) {
		super(id, "account", accountStatus, entityType, Arrays.asList("Loan Account", "Account"));
	}

	public String getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(String loanDuration) {
		this.loanDuration = loanDuration;
	}
}
