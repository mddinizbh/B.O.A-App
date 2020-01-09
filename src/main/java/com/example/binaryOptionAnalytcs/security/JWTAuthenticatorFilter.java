package com.example.binaryOptionAnalytcs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.binaryOptionAnalytcs.dto.CredenciaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticatorFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticatorManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticatorFilter(AuthenticationManager authenticatorManager, JWTUtil jwtUtil) {
		
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticatorManager = authenticatorManager;
		this.jwtUtil = jwtUtil;
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
							HttpServletResponse response) throws AuthenticationException{
		
		try {
			CredenciaisDTO credenciais = new ObjectMapper().readValue(request.getInputStream(), CredenciaisDTO.class);
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credenciais.getLogin(), 
																									credenciais.getSenha(),
																									new ArrayList<>());
			Authentication auth = authenticatorManager.authenticate(authToken);
			
			return auth;
			
			
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	
	}
	

	@Override
	public void successfulAuthentication(HttpServletRequest request,
										HttpServletResponse response,
										FilterChain chain,
										Authentication auth) throws IOException,ServletException{
		
		UsuarioSS usu =((UsuarioSS) auth.getPrincipal());
		String login = usu.getUsername();
		String token = jwtUtil.gerarToken(login);
		response.addHeader("Authorization", "Bearer "+ token);
		
	}
	
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
		              throws IOException, ServletException {
		          response.setStatus(401);
		          response.setContentType("application/json"); 
		          response.getWriter().append(json());
		      }
		      
		      private String json() {
		          long date = new Date().getTime();
		          return "{\"timestamp\": " + date + ", "
		              + "\"status\": 401, "
		              + "\"error\": \"Não autorizado\", "
		              + "\"message\": \"Email ou senha inválidos\", "
		              + "\"path\": \"/login\"}";
		      }
	}
	
}
