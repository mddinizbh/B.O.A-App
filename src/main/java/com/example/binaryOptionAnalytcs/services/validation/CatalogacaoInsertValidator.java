package com.example.binaryOptionAnalytcs.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.binaryOptionAnalytcs.dto.BancaNewDTO;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class CatalogacaoInsertValidator extends GenericValidator implements ConstraintValidator<BancaInsert, BancaNewDTO>  {


	
	public void validarCampos(BancaNewDTO value) {
		if(value.getIdUsario() == null) {
			list.add(new FieldMessage("idUsuario",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}
		
		if(value.getValorInicial() == null) {
			list.add(new FieldMessage("valorInicial",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if (value.getValorInicial() <= 0) {
			list.add(new FieldMessage("valorInicial",messageLocale.getMessage("valor.maior.zero") ));
		}
		
		if(value.getNome() == null) {
			list.add(new FieldMessage("Nome",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}
		
		
		if(value.getStopGain() == null) {
			list.add(new FieldMessage("StopGain",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(value.getStopGain() <= 0) {
			list.add(new FieldMessage("StopGain",messageLocale.getMessage("valor.maior.zero") ));
		}
		
		
		if(value.getStopLoss() == null) {
			list.add(new FieldMessage("StopLoss",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}else if(value.getStopLoss() <= 0) {
			list.add(new FieldMessage("StopLoss",messageLocale.getMessage("valor.maior.zero") ));
		}
		
	}
	
	@Override
	public void initialize(BancaInsert ann) {
		
	}
	@Override
	public boolean isValid(BancaNewDTO value, ConstraintValidatorContext context) {
		
			validarCampos(value);
			populaContext(context);	
		
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	

}
