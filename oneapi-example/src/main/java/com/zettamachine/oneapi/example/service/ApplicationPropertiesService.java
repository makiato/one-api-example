package com.zettamachine.oneapi.example.service;

public class ApplicationPropertiesService {
	
	//@Value("${spring.jersey.applicationPath}")
	private String apiPath;
	
	//@Value("${oneapi.server.url}")
	private String serverUrl;

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	// TODO Because I couldn't get @Value to work. Intent was to fetch these from applcaition.properties.
	public String getBaseURL() {
		return "http://localhost:8080/one-api/v1/";
	}

}
