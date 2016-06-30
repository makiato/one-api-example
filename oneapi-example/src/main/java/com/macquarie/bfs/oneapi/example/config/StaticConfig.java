package com.macquarie.bfs.oneapi.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class StaticConfig {
	
	@Value("${spring.jersey.applicationPath}")
	public static String API_PATH; 

}
