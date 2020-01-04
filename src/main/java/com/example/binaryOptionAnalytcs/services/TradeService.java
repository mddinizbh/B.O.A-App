package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.TradeDTO;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.entities.Trade;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.repositories.TradeRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class TradeService {
	
	@Autowired
	TradeRepository repository;
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<Trade> findAll(){
		List <Trade> trades = repository.findAll();
		
		return trades;
	}
	
	public Trade findById(Long id) {
		Optional<Trade> trade = repository.findById(id);
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= EstrategiaCatalog.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args);
		
		return trade.orElseThrow(() -> new ObjectNotFoundException(msg));
		
	}
	
	public Page<Trade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Trade insert(Trade obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Trade update(Trade obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_TRADE.getMenssagem()));
		}
	}
	
	public Trade fromDTO(TradeDTO dto) {
		
		return new Trade(dto.getId(), dto.getValorPayOut(), dto.getValorResultado(),dto.getTradeStatus());
	}


}
