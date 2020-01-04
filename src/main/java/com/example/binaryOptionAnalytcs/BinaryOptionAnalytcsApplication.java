package com.example.binaryOptionAnalytcs;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication(scanBasePackages = {"com"})
public class BinaryOptionAnalytcsApplication {

	
	

	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver resolver = new SessionLocaleResolver();
	    resolver.setDefaultLocale(Locale.US);
	    return resolver;
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BinaryOptionAnalytcsApplication.class, args);
	}

}
