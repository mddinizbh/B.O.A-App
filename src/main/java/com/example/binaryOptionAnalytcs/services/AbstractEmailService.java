package com.example.binaryOptionAnalytcs.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.example.binaryOptionAnalytcs.entities.Cliente;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("$default.sender")
	private String sender;
	
	@Override
	public void sendNewPassword(Cliente usu, String newPass) {
		SimpleMailMessage sm = prepareNewPassWordEmail(usu,newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPassWordEmail(Cliente usu, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usu.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("A sua nova senha é: "+newPass);
		
		return sm;
	}
}
