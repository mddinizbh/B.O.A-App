package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.AporteDTO;
import com.example.binaryOptionAnalytcs.dto.AporteNewDTO;
import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.AporteRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class AporteService {
	
	@Autowired
	private AporteRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	
	
	public List<Aporte> findAll(){
		List <Aporte> usuarios = repository.findAll();
		
		return usuarios;
	}
	
	public Aporte findById(Long id) {
		Optional<Aporte> aporte = repository.findById(id);
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= Aporte.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return aporte.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
public Page<Aporte> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Aporte insert(Aporte obj) {
		obj.setId(null);
		return repository.save(obj);
	}


	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException((MensagensEnum.ERRO_DELETAR_APORTE.getMenssagem()));
		}
	}
	
	public Aporte fromDTO(AporteDTO dto) {
		
		return new Aporte(dto.getId(),dto.getValorAporte());
		
	}

	public Aporte fromNewDTO(AporteNewDTO dto) {
		// TODO Auto-generated method stub
		return new Aporte(null,dto.getValorAporte());
	}

}
