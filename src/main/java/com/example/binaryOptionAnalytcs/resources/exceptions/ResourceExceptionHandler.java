package com.example.binaryOptionAnalytcs.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;
/**
 * 
 * Classe criada para manipular exceções
 * 
 * @author Marley
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest resquest){
		StandardError error = new StandardError (HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityException e, HttpServletRequest resquest){
		StandardError error = new StandardError (HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest resquest){
		ValidationError error = new ValidationError (HttpStatus.BAD_REQUEST.value(), "Erro de Validação", System.currentTimeMillis());
		
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
	
}
