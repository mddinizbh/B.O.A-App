package com.example.binaryOptionAnalytcs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {
	
	@Autowired
	private MailSender ms;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class); 
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		
		
		LOG.info("Enviando email...");
		ms.send(msg);
		LOG.info("Email enviado");
		
	}

}
