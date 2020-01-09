package com.example.binaryOptionAnalytcs.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.binaryOptionAnalytcs.dto.CatalogacaoNewDTO;
import com.example.binaryOptionAnalytcs.resources.exceptions.FieldMessage;

public class CatalogacaoInsertValidator extends GenericValidator implements ConstraintValidator<CatalogacaoInsert, CatalogacaoNewDTO>  {


	
	public void validarCampos(CatalogacaoNewDTO value) {
		if(value.getIdCliente() == null) {
			list.add(new FieldMessage("idCliente",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}
		if(value.getIdParMoeda() == null) {
			list.add(new FieldMessage("idParMoeda",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}
			
		if(value.getNome() == null) {
			list.add(new FieldMessage("nome",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}		
		
		if(value.getHoraInicio() == null) {
			list.add(new FieldMessage("horaInicio",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}if(value.getHoraFim() == null) {
			list.add(new FieldMessage("horaFim",messageLocale.getMessage("preenchimento.obrigatorio") ));
		}if(value.getHoraFim()!=null && value.getHoraInicio()!=null) {
			
			Integer horaInicio = Integer.parseInt(value.getHoraInicio().split(":")[0]);
			Integer minutoInicio = Integer.parseInt(value.getHoraInicio().split(":")[1]);
			Integer horaFim = Integer.parseInt(value.getHoraFim().split(":")[0]);
			Integer minutoFim = Integer.parseInt(value.getHoraFim().split(":")[1]);
			
			if(horaInicio>horaFim) {
				list.add(new FieldMessage("horaInicio",messageLocale.getMessage("hora.inicio.maior.hora.fim") ));
			}else if(horaInicio==horaFim) {
				if(minutoInicio>=minutoFim) {
					list.add(new FieldMessage("horaInicio",messageLocale.getMessage("hora.inicio.maior.hora.fim") ));
				}
			}
			
		}
}
	
	@Override
	public void initialize(CatalogacaoInsert ann) {
		
	}
	@Override
	public boolean isValid(CatalogacaoNewDTO value, ConstraintValidatorContext context) {
		
			validarCampos(value);
			populaContext(context);	
		
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	

}
