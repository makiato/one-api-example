package com.zettamachine.oneapi.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.zettamachine.oneapi.example.service.ApplicationPropertiesService;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		packages("com.macquarie.bfs.oneapi.example.resource");
	}	
}
