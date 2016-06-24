package com.macquarie.bfs.oneapi.example.service;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.macquarie.bfs.oneapi.example.OneAPIException;
import com.macquarie.bfs.oneapi.example.entity.common.ErrorResponse;
import com.macquarie.bfs.oneapi.example.entity.common.SuccessResponse;
import com.macquarie.bfs.oneapi.example.entity.model.Response;
import com.macquarie.bfs.oneapi.example.repository.AccountRepository;

@Singleton
@Service
public class AccountService {
	AccountRepository accountsRep;
	
	public AccountService() {
		accountsRep = new AccountRepository();
	}
		
	public Response getAccount(String id) {
		Response response;
		try {
			SuccessResponse success = new SuccessResponse();
			success.addEntityToData(accountsRep.getAccount(id));
			response = success;
		} catch(OneAPIException x) {
			ErrorResponse failure = new ErrorResponse();
			failure.addErrorObject(x.getError());
			response = failure;
		}
		return response;
	}
	
	public Response getAccounts(int offset, int limit) {
		Response response;
		try {
			SuccessResponse success = new SuccessResponse();
			success.setData(accountsRep.getAccountsPaginated(offset, limit));
			response = success;
		} catch(OneAPIException x) {
			ErrorResponse failure = new ErrorResponse();
			failure.addErrorObject(x.getError());
			response = failure;
		}
		return response;
	}
}
