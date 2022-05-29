package com.fabio.rest.api.jwt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidateUtils {
	

	
	public Claims getClaimsFromToken(String token) throws Exception{
		
		PublicKey publicKey = getPublicKey();

        Jws<Claims> jwt = Jwts.parser()
                .setSigningKey(publicKey).parseClaimsJws(token);
        return jwt.getBody();
	}
	
	public String gerUsernameFromToken(String token) throws Exception {
		if(!StringUtils.isEmpty(token)) {
			if(!isExpired(token)) {
				String username=(String)getClaimsFromToken(token).get("username");
				return username;
			}else {
				throw new Exception("Il token è scaduto.");
			}
			
		}else {
			throw new Exception("Nessun token valorizzato");
		}
		
	}
	
	
	public boolean isExpired(String token) throws Exception{
		Claims claims=getClaimsFromToken(token);
		Date d=claims.getExpiration();
		
		return d.before(new Date());
	}
	
	
    private  PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String rsaPublicKey = "-----BEGIN PUBLIC KEY-----" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyu3NB7Tr3nzETLNbZHYi" +
                "ZvgNeg3/OZUJZl40LzBzYGOD/8575eJETjfQ3QXaNyvNThu6Uf9B/V73QUxKI4/+" +
                "rwlbjA3niIga4MdDiY4b9K/KFA+HedvtZF1yE2p4smXGydPLOLBe31EgriGTob78" +
                "EE3f7SMFxlNaqn4Pm7KJkOodnMz0ilwLseeL1IkTtiFn/2OrcMpPHMtTxyDn3pQl" +
                "VCeJM5j/grDh+0YdyTMGdDHOBgM53VqSsDVyo1TNtP2yhPRYCIiI85hEHVaUnVM9" +
                "jGwCjNZLJHWh10Mrmh6B3z8BEmLhMAZXeL4fQBjBd42DLvIIJwM1USKFhjK+XghN" +
                "rQIDAQAB" +
                "-----END PUBLIC KEY-----";
        rsaPublicKey = rsaPublicKey.replace("-----BEGIN PUBLIC KEY-----", "");
        rsaPublicKey = rsaPublicKey.replace("-----END PUBLIC KEY-----", "");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(rsaPublicKey));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(keySpec);
        return publicKey;
    }
}
