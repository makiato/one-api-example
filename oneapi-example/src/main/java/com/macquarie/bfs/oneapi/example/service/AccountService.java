package com.macquarie.bfs.oneapi.example.service;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.macquarie.bfs.oneapi.example.OneAPIException;
import com.macquarie.bfs.oneapi.example.entity.common.DataSetObject;
import com.macquarie.bfs.oneapi.example.entity.common.ResponseObject;
import com.macquarie.bfs.oneapi.example.entity.model.Response;
import com.macquarie.bfs.oneapi.example.repository.AccountRepository;

@Singleton
@Service
public class AccountService {
	AccountRepository accountsRep;
	HttpServletRequest request;
	
	public AccountService set(HttpServletRequest request) {
		this.request = request;
		return this;
	}
	
	public AccountService() {
		accountsRep = new AccountRepository();
	}
		
	public Response getAccount(String id) {
		Response response = new ResponseObject();
		try {
			response.setData(accountsRep.getAccount(id));
		} catch(OneAPIException x) {
			response.addErrorObject(x.getError());
		}
		return response;
	}
	
	public Response getAccounts(int offset, int limit, String type) {
		Response response = new ResponseObject();
		try {
			response.setData(accountsRep.getAccountsPaginated(offset, limit, type));
			response.getMeta().setDataSet(new DataSetObject(offset, limit, accountsRep.getSize(), request.getRequestURI()));
		} catch(OneAPIException x) {
			response.addErrorObject(x.getError());
		}
		return response;
	}
}
