package com.example.binaryOptionAnalytcs.services;

import java.io.Serializable;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.binaryOptionAnalytcs.security.UsuarioSS;

public class UserService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static UsuarioSS authenticado() {
		try {
			
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
	}

}
