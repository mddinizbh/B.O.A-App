package com.example.binaryOptionAnalytcs.services.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.example.binaryOptionAnalytcs.dto.UsuarioDTO;
import com.example.binaryOptionAnalytcs.entities.Usuario;
import com.example.binaryOptionAnalytcs.repositories.UsuarioRepository;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class UsuarioUpdateValidator extends GenericValidator implements ConstraintValidator<UsuarioInsert, UsuarioDTO>  {

		@Autowired	
		private UsuarioRepository repo;
		@Autowired
		private HttpServletRequest request;
		
		public void validarCampos(UsuarioDTO value) {
			
		@SuppressWarnings("unchecked")
		Map <String,String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = Long.parseLong(map.get("id"));
		
		/**
		 * Validação da email	
		 */
		if (value.getEmail() == null){
			list.add(new FieldMessage("email",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(!value.getEmail().contains("@")) {
			list.add(new FieldMessage("email",messageLocale.getMessage("email.invalido") ));
		} else {
			Usuario aux = repo.findByEmail(value.getEmail());
			if (aux!=null && !aux.getId().equals(id)) {
				list.add(new FieldMessage("email",messageLocale.getMessage("email.cadastrado") ));
			}
		
		}							
		
	
	}
	
	@Override
	public void initialize(UsuarioInsert ann) {
		
	}
	@Override
	public boolean isValid(UsuarioDTO value, ConstraintValidatorContext context) {
		
			validarCampos(value);
			populaContext(context);	
		
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	

}
