package com.fabio.rest.jwt_token_svc;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.fabio.rest.jwt.utils.JwtTokenUtils;

public class Test {

	public static void main(String[] args) {
		JwtTokenUtils jwtUtils=new JwtTokenUtils();
		try {
			String token=jwtUtils.generaToken("fabioasr89");
			System.out.println(token);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
