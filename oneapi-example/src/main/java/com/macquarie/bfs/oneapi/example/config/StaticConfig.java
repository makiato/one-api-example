package com.macquarie.bfs.oneapi.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticConfig {
	
	@Value("${api.version}")
	public static String API_VERSION; 

}
