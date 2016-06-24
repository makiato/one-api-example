package com.macquarie.bfs.oneapi.example.repository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.macquarie.bfs.oneapi.example.OneAPIException;
import com.macquarie.bfs.oneapi.example.entity.LoanAccount;
import com.macquarie.bfs.oneapi.example.entity.TransactionAccount;
import com.macquarie.bfs.oneapi.example.entity.common.ErrorObject;
import com.macquarie.bfs.oneapi.example.entity.model.Entity;

public class AccountRepository {
	SecureRandom random;
	List<Entity> accounts;
	static Map<String, Entity> accountsRep = null;
	
	public AccountRepository() {
		random = new SecureRandom();
		accountsRep = new HashMap<String, Entity>();
		int i = 0; Entity entity;
		while(i < 100) {
			entity = generateRandomAccount();
			accountsRep.put(entity.getId(), entity);
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
			ErrorObject error = new ErrorObject("U001", "This hapenned" + x.getClass().getName());
			throw new OneAPIException(error, 500);
		}
	}

	public List<Entity> getAccountsPaginated(int offset, int limit) throws OneAPIException {
		try {
			return accounts.subList(offset, offset+limit);
		} catch(IndexOutOfBoundsException x) {
			ErrorObject error = new ErrorObject("F103", "Offset and Limit combination is out of range");
			throw new OneAPIException(error, 200);
		}
	}
	
	public List<Entity> getAllAccounts() {
		return accounts;
	}
	
	public Entity generateRandomAccount() {
		Entity account = null;
		int r = random.nextInt(2) + 1;
		switch (r) {
			case 1: 
				account = new TransactionAccount(UUID.randomUUID().toString(), generateRandomStatus());
				break;
			case 2:
				LoanAccount loan = new LoanAccount(UUID.randomUUID().toString(), generateRandomStatus());
				loan.setLoanType("Basic Home Loan");
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
	
	public static void main(String[] args) {
		AccountRepository rep = new AccountRepository();
		System.out.println(rep.generateRandomStatus());
		System.out.println(rep.generateRandomStatus());
		System.out.println(rep.generateRandomStatus());
	}
	
}
