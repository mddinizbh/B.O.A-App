package com.example.binaryOptionAnalytcs.repositories;

public interface MessageByLocaleRepository{
	
	public String getMessage(String id);
	
	public String getMessageFormatada(String id,String param);
	
	public String getMessage(String code, Object[] args);
	
	
		
	
}
