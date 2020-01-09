package com.example.binaryOptionAnalytcs.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.binaryOptionAnalytcs.dto.ClienteNewDTO;
import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.repositories.ClienteRepository;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class ClienteInsertValidator extends GenericValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>  {

		@Autowired	
		private ClienteRepository repo;
		
		public void validarCampos(ClienteNewDTO value) {
		if (value.getNome() == null) {
			list.add(new FieldMessage("nome",messageLocale.getMessage("preenchimento.obrigatorio") ));
		} else if(value.getNome().length()<5 ||value.getNome().length()>80 ){
			list.add(new FieldMessage("nome",messageLocale.getMessage("tamanho.5a80") ));
		}
		/**
		 * Validação da email	
		 */
		if (value.getEmail() == null){
			list.add(new FieldMessage("email",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(!value.getEmail().contains("@")) {
			list.add(new FieldMessage("email",messageLocale.getMessage("email.invalido") ));
		} else {
			Cliente aux = repo.findByEmail(value.getEmail());
			if (aux!=null) {
				list.add(new FieldMessage("email",messageLocale.getMessage("email.cadastrado") ));
			}
		
		}
		
		/**
		 * Validação da Login	
		 */
		if(value.getLogin()==null) {
			list.add(new FieldMessage("login",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(value.getLogin().length()<5 ||value.getNome().length()>20 ){
			list.add(new FieldMessage("login",messageLocale.getMessage("tamanho.5a20") ));
		}else {
			Cliente aux = repo.findByLogin(value.getLogin());
			if (aux!=null) {
				list.add(new FieldMessage("login",messageLocale.getMessage("login.cadastrado") ));
			}
		
		}
			
			
		/**
		 * Validação da senha	
		 */
		if(value.getSenha()==null) {
			list.add(new FieldMessage("senha",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(value.getSenha().length()<5 ||value.getNome().length()<20 ){
			list.add(new FieldMessage("senha",messageLocale.getMessage("tamanho.5a20") ));
		}
		
		
	
	}
	
	@Override
	public void initialize(ClienteInsert ann) {
		
	}
	@Override
	public boolean isValid(ClienteNewDTO value, ConstraintValidatorContext context) {
		
			validarCampos(value);
			populaContext(context);	
		
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	

}
