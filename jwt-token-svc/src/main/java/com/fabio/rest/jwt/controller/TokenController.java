package com.fabio.rest.jwt.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.http.HttpServletRequest;

import com.fabio.rest.jwt.utils.JwtTokenUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/services/authentication/")
public class TokenController {
	
	@Autowired
	private JwtTokenUtils jwtTokenUtils;
	
	@GetMapping("token")
	public ResponseEntity<String> getToken(HttpServletRequest request){
		String username=request.getHeader("username");
		boolean error=false;
		if(username!=null) {
			try {
				String token=jwtTokenUtils.generaToken(username);
				return new ResponseEntity<String>(token,HttpStatus.ACCEPTED);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				error=true;
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error=true;
			}
			
		}else {
			error=true;
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
