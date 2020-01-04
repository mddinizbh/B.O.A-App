package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.EstrategiaDTO;
import com.example.binaryOptionAnalytcs.entities.Estrategia;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class EstrategiaService {
	
	@Autowired
	private EstrategiaRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<Estrategia> findAll(){
		List <Estrategia> estrategias = repository.findAll();
		
		return estrategias;
	}
	
	public Estrategia findById(Long id) {
		Optional<Estrategia> estrategia = repository.findById(id);

	
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= Estrategia.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return estrategia.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<Estrategia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}

	public Estrategia insert(Estrategia obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Estrategia update(Estrategia obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_ESTRATEGIA.getMenssagem()));
		}
	}
	
	
	public Estrategia fromDTO(EstrategiaDTO dto) {
		
		return new Estrategia(dto.getId(),dto.getNome(), dto.getDescricao());
		
	}

}
