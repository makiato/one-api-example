package com.macquarie.bfs.oneapi.example.repository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.macquarie.bfs.oneapi.example.OneAPIException;
import com.macquarie.bfs.oneapi.example.entity.LoanAccount;
import com.macquarie.bfs.oneapi.example.entity.TransactionAccount;
import com.macquarie.bfs.oneapi.example.entity.common.ErrorObject;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;
import com.macquarie.bfs.oneapi.example.service.ApplicationPropertiesService;

public class AccountRepository {
	SecureRandom random;
	List<Entity> accounts;
	List<Entity> loanAccounts = new ArrayList<Entity>();
	List<Entity> txnAccounts = new ArrayList<Entity>();
	List<String> txnAccountTypes = Arrays.asList("Macquarie Platinum Transaction Account","Macquarie Transaction Account","Macquarie Savings Account","Clearing Account","Woolworths Premium Transaction Account");
	List<String> loanAccountTypes = Arrays.asList("Basic Home Loan","Offset Home Loan","Line of Credit Home Loan","SMSF Property Loan","Reverse Mortgage");
	
	ApplicationPropertiesService properties = new ApplicationPropertiesService();
	
	int size = 0;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	static Map<String, Entity> accountsRep = null;
	
	public AccountRepository() {
		random = new SecureRandom();
		accountsRep = new HashMap<String, Entity>();
		int i = 0; Entity entity;
		while(i < 100) {
			entity = generateRandomAccount();
			accountsRep.put(entity.getId(), entity);
			if(entity.getParentEntityTypes().contains("Loan Account")) loanAccounts.add(entity);
			if(entity.getParentEntityTypes().contains("Transaction Account")) txnAccounts.add(entity);
			i++;
		}
		accounts = new ArrayList<Entity>(accountsRep.values());
	}
	
	public Map<String, Entity> getAccountsRep() {
		return accountsRep;
	}
	
	public Entity getAccount(String id) throws OneAPIException {
		try {
			if(accountsRep.get(id) == null) {
				ErrorObject error = new ErrorObject("T404", "Resource Not Found");
				throw new OneAPIException(error, 400);
			}
			return accountsRep.get(id);
		} catch(Exception x) {
			ErrorObject error = new ErrorObject("U001", "This happenned > " + x.getClass().getName() + " - " + x.getMessage());
			throw new OneAPIException(error, 500);
		}
	}

	public List<Entity> getAccountsPaginated(int offset, int limit, String type) throws OneAPIException {
		try {
			if(type.equals("Loan Account")) {
				setSize(loanAccounts.size());
				return loanAccounts.subList(offset, offset+limit);
			} else if(type.equals("Transaction Account")) {
				setSize(txnAccounts.size());
				return txnAccounts.subList(offset, offset+limit);
			} else {
				setSize(accounts.size());
				return accounts.subList(offset, offset+limit);
			}
		} catch(IndexOutOfBoundsException x) {
			ErrorObject error = new ErrorObject("F103", "Offset and Limit combination is out of range");
			throw new OneAPIException(error, 200);
		}
	}
	
	public List<Entity> getAllAccounts() {
		return accounts;
	}
	
	@PostConstruct
	public Entity generateRandomAccount() {
		Entity account = null;
		int r = random.nextInt(2) + 1;
		switch (r) {
			case 1: 
				TransactionAccount transaction = new TransactionAccount(UUID.randomUUID().toString(), generateRandomStatus(), generateRandomTransactionAccount());
				transaction.setSelf(properties.getBaseURL() + "accounts/" + transaction.getId());
				account = transaction;
				break;
			case 2:
				LoanAccount loan = new LoanAccount(UUID.randomUUID().toString(), generateRandomStatus(), generateRandomLoanAccount());
				loan.setLoanDuration("P" + (random.nextInt(20) + 10) + "Y");
				loan.setSelf(properties.getBaseURL() + "accounts/" + loan.getId());
				account = loan;
				break;
		}
		return account;
	}
	
	public String generateRandomStatus() {
		String status = null;
		int r = random.nextInt(3) + 1;
		switch (r) {
			case 1: status = "Active"; break;
			case 2: status = "Closed"; break;
			case 3: status = "Active"; break;
		}
		return status;
	}
	
	public String generateRandomTransactionAccount() {
		return txnAccountTypes.get(random.nextInt(txnAccountTypes.size()));
	}
	
	public String generateRandomLoanAccount() {
		return loanAccountTypes.get(random.nextInt(loanAccountTypes.size()));
	}
	
	public static void main(String[] args) {
		AccountRepository rep = new AccountRepository();
		System.out.println(rep.generateRandomStatus());
		System.out.println(rep.generateRandomStatus());
		System.out.println(rep.generateRandomStatus());
	}
	
}
