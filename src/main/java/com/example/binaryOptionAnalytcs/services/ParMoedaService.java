package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.ParMoedaDTO;
import com.example.binaryOptionAnalytcs.entities.ParMoeda;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.repositories.ParMoedaRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class ParMoedaService {
	
	@Autowired
	private ParMoedaRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<ParMoeda> findAll(){
		List <ParMoeda> ParMoedas = repository.findAll();
		
		return ParMoedas;
	}
	
	public ParMoeda findById(Long id) {
		Optional<ParMoeda> ParMoeda = repository.findById(id);

	
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= ParMoeda.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return ParMoeda.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<ParMoeda> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}

	public ParMoeda insert(ParMoeda obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ParMoeda update(ParMoeda obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_PARMOEDA.getMenssagem()));
		}
	}
	
	
	public ParMoeda fromDTO(ParMoedaDTO dto) {
		
		return new ParMoeda(dto.getId(),dto.getNome());
		
	}

}
