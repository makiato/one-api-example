package com.zettamachine.oneapi.example.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.zettamachine.oneapi.example.entity.model.Response;
import com.zettamachine.oneapi.example.service.AccountService;

@Path("/accounts")
@Component
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT})
	public Response getAccounts(
			@DefaultValue("0") @QueryParam("offset") int offset, 
			@DefaultValue("10") @QueryParam("limit") int limit, 
			@DefaultValue("*") @QueryParam("type") String type,
			@DefaultValue("NULL") @HeaderParam("X-Request-ID") String xRequestId,
			@Context HttpServletRequest request) {
		return accountService.set(request).getAccounts(offset, limit, type);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT, SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED})
	@Path("/{id}")
	public Response getAccount(@PathParam("id") String id, @Context HttpServletRequest request) {
		return accountService.set(request).getAccount(id);
	}
}
