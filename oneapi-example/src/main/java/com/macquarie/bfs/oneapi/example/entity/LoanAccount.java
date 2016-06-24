package com.macquarie.bfs.oneapi.example.entity;

import com.macquarie.bfs.oneapi.example.entity.model.AbstractAccount;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;

public class LoanAccount extends AbstractAccount implements Entity {
	String loanType;
	
	public LoanAccount(String id, String accountStatus) {
		super(id, "LoanAccount", accountStatus);
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
}
