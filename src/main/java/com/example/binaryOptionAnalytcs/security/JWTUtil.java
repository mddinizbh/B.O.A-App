package com.example.binaryOptionAnalytcs.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	@Value ("${jwt.secret}")
	private String secret;
	
	@Value ("${jwt.expiration}")
	private String expiration;
	

	public String gerarToken(String username) {
		 Long expirationLong = Long.parseLong(expiration);
		
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date (System.currentTimeMillis()+expirationLong))
				.signWith(SignatureAlgorithm.HS512,secret.getBytes())
				.compact();
				
	}

	public boolean validToken(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			String username = claims.getSubject();
		    Date expirationDate = claims.getExpiration();
		    Date now = new Date(System.currentTimeMillis());
		    if(username!=null && expirationDate!=null && now.before(expirationDate)) {
		    	return true;
		    }
			
		}
		return false;
	}

	private Claims getClaims(String token) {
		try {
			token = token.substring(7);
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}catch (Exception e) {
			System.out.println(e.getMessage());	
			return null;
		}
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			return  claims.getSubject();
		}
		return null;
	}
}
