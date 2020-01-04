package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.DayTradeDTO;
import com.example.binaryOptionAnalytcs.entities.DayTrade;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.DayTradeRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class DayTradeService {
	
	@Autowired
	private DayTradeRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<DayTrade> findAll(){
		List <DayTrade> DayTrades = repository.findAll();
		
		return DayTrades;
	}
	
	public DayTrade findById(Long id) {
		Optional<DayTrade> DayTrade = repository.findById(id);
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= DayTrade.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return DayTrade.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<DayTrade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public DayTrade insert(DayTrade obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public DayTrade update(DayTrade obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_DAYTRADE.getMenssagem()));
		}
	}
	
	public DayTrade fromDTO(DayTradeDTO dto) {
		
		return new DayTrade(dto.getData(),dto.getValorReal(), dto.getValorPorc());
	}


}
