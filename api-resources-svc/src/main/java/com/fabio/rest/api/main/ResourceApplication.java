package com.fabio.rest.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fabio.rest.api.controller","com.fabio.rest.api.jwt"})
public class ResourceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
