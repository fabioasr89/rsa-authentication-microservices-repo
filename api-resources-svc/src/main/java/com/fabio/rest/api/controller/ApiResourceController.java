package com.fabio.rest.api.controller;

import javax.servlet.http.HttpServletRequest;

import com.fabio.rest.api.jwt.JwtValidateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="services/api/resources/")
public class ApiResourceController {
	
	@Autowired
	private JwtValidateUtils jwtValidateUtils;
	
	@GetMapping("user")
	public ResponseEntity<String> getUsername(HttpServletRequest request) {
		String token=request.getHeader("token-jwt");
		try {
			String username=jwtValidateUtils.gerUsernameFromToken(token);
			return new ResponseEntity<String>(username,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
