package com.zettamachine.oneapi.example.service;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zettamachine.oneapi.example.OneAPIException;
import com.zettamachine.oneapi.example.entity.common.DataSetObject;
import com.zettamachine.oneapi.example.entity.common.ResponseObject;
import com.zettamachine.oneapi.example.entity.model.Response;
import com.zettamachine.oneapi.example.repository.AccountRepository;

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
			if(request.getHeader("X-Request-ID") != null) {
				response.getMeta().setRequestId(request.getHeader("X-Request-ID"));
			}
		} catch(OneAPIException x) {
			response.addErrorObject(x.getError());
		}
		return response;
	}
	
	public Response getAccounts(int offset, int limit, String type) {
		Response response = new ResponseObject();
		try {
			response.setData(accountsRep.getAccountsPaginated(offset, limit, type));
			response.getMeta().setDataSet(new DataSetObject(offset, limit, accountsRep.getSize(), request.getRequestURL().toString()));
			if(request.getHeader("X-Request-ID") != null) {
				response.getMeta().setRequestId(request.getHeader("X-Request-ID"));
			}
		} catch(OneAPIException x) {
			response.addErrorObject(x.getError());
		}
		return response;
	}
}
