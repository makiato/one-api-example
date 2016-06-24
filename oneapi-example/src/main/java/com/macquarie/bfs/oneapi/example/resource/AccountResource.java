package com.macquarie.bfs.oneapi.example.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.macquarie.bfs.oneapi.example.entity.model.Response;
import com.macquarie.bfs.oneapi.example.service.AccountService;

@Path("/")
@Component
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT})
	@Path("/accounts")
	public Response getAccounts(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("10") @QueryParam("limit") int limit) {
		return accountService.getAccounts(offset, limit);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT})
	@Path("/accounts/{id}")
	public Response getAccount(@PathParam("id") String id) {
		return accountService.getAccount(id);
	}
}
