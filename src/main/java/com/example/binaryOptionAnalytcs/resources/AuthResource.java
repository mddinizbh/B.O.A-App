package com.example.binaryOptionAnalytcs.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.dto.EmailDTO;
import com.example.binaryOptionAnalytcs.security.JWTUtil;
import com.example.binaryOptionAnalytcs.security.UsuarioSS;
import com.example.binaryOptionAnalytcs.services.AuthService;
import com.example.binaryOptionAnalytcs.services.UserService;

@RestController
@RequestMapping(value ="/auth")
public class AuthResource {
	@Autowired
	private JWTUtil jwtutil;
	
	@Autowired
	private AuthService service;
	
	
	@RequestMapping(value="/refresh_token", method= RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		UsuarioSS user = UserService.authenticado();
		String token = jwtutil.gerarToken(user.getUsername());
		response.addHeader("Authorization", "Bearer "+token);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/forgotPassword", method= RequestMethod.POST)
	public ResponseEntity<Void> forgotPassword(@Valid @RequestBody EmailDTO objDto){
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}


}
