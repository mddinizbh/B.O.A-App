package com.example.binaryOptionAnalytcs.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.binaryOptionAnalytcs.dto.AporteNewDTO;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class AporteInsertValidator extends GenericValidator implements ConstraintValidator<AporteInsert, AporteNewDTO>  {


	
	public void validarCampos(AporteNewDTO value) {
		
		if(value.getBancaId()==null) {
			list.add(new FieldMessage("valorAporte",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}
		
		if(value.getValorAporte() == null) {
			list.add(new FieldMessage("valorAporte",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if (value.getValorAporte() <= 0) {
			list.add(new FieldMessage("valorAporte",messageLocale.getMessage("valor.maior.zero") ));
		}
		
	}
	
	@Override
	public void initialize(AporteInsert ann) {
		
	}
	@Override
	public boolean isValid(AporteNewDTO value, ConstraintValidatorContext context) {
		
			validarCampos(value);
			populaContext(context);	
		
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	

}
