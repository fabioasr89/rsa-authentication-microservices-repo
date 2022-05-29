package com.fabio.rest.jwt.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.fabio.rest.jwt.controller","com.fabio.rest.jwt.utils"})
public class JwtTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenApplication.class, args);

	}

}
