package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.RetiradaDTO;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.entities.Retirada;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.repositories.RetiradaRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class RetiradaService {
	
	@Autowired
	private RetiradaRepository repository;
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<Retirada> findAll(){
		List <Retirada> retiradas = repository.findAll();
		
		return retiradas;
	}
	
	public Retirada findById(Long id) {
		Optional<Retirada> retirada = repository.findById(id);
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= EstrategiaCatalog.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return retirada.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<Retirada> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Retirada insert(Retirada obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Retirada update(Retirada obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_RETIRADA.getMenssagem()));
		}
	}
	
	public Retirada fromDTO(RetiradaDTO dto) {
		
		return new Retirada(dto.getValorRetirada(), dto.getDataRetirada(), dto.getDescricao());
	}


}
