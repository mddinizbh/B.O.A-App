package com.example.binaryOptionAnalytcs.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class GenericValidator {
	
	List <FieldMessage> list = new ArrayList<FieldMessage>();
	
	@Autowired
	MessageByLocaleRepository messageLocale;
	
		
	
	public void populaContext(ConstraintValidatorContext context) {
		
		for (FieldMessage e : list) {
			 
			context.disableDefaultConstraintViolation(); 
			context.buildConstraintViolationWithTemplate(e.getMessage()) 
			.addPropertyNode(e.getFieldName()).addConstraintViolation();  
	   } 
	}
	
}
