package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.EstrategiaCatalogDTO;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaCatalogRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class EstrategiaCatalogService {
	
	@Autowired
	private EstrategiaCatalogRepository repository;
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	
	public List<EstrategiaCatalog> findAll(){
		List <EstrategiaCatalog> estrategiaCatalogs = repository.findAll();
		
		return estrategiaCatalogs;
	}
	
	public EstrategiaCatalog findById(Long id) {
		
		Optional<EstrategiaCatalog> estrategiaCatalog = repository.findById(id);
		
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= EstrategiaCatalog.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return estrategiaCatalog.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<EstrategiaCatalog> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public EstrategiaCatalog insert(EstrategiaCatalog obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public EstrategiaCatalog update(EstrategiaCatalog obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_ESTRATEGIA_CATOLOGACAO.getMenssagem()));
		}
	}
	
	
	public EstrategiaCatalog fromDTO(EstrategiaCatalogDTO dto) {
		
		return new EstrategiaCatalog(dto.getId(),dto.getQtdOperacaoes(), dto.getQtdWin(),dto.getQtdLose(), dto.getQtdMG(),dto.getQtdMGs());
	}

}
