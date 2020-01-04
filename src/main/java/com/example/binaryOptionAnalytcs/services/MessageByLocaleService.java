package com.example.binaryOptionAnalytcs.services;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;

@Component
public class MessageByLocaleService implements MessageByLocaleRepository {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String getMessage(String id) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(id,null,locale);
	}

	@Override
	public String getMessageFormatada(String id, String param) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String msg  = messageSource.getMessage(id,null,locale);
		
		return MessageFormat.format(msg, param);
		
	}
	@Override
	public String getMessage(String code, Object[] args) {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return	messageSource.getMessage(code, args, locale);
	}
}
