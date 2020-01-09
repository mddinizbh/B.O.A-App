package com.example.binaryOptionAnalytcs.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.binaryOptionAnalytcs.services.DBService;
import com.example.binaryOptionAnalytcs.services.EmailService;
import com.example.binaryOptionAnalytcs.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
   
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws Exception {
		
		dbService.instantiateDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
	
