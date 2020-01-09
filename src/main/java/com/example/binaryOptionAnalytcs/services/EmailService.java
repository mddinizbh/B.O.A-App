package com.example.binaryOptionAnalytcs.services;

import org.springframework.mail.SimpleMailMessage;

import com.example.binaryOptionAnalytcs.entities.Cliente;


public interface EmailService {

	
	
	void sendNewPassword(Cliente usu, String newPass);
	
	void sendEmail(SimpleMailMessage msg);

		
}
