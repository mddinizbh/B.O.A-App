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
import com.example.binaryOptionAnalytcs.entities.Trade;
import com.example.binaryOptionAnalytcs.repositories.TradeRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class TradeService {
	
	@Autowired
	TradeRepository repository;
	
	
	public List<Trade> findAll(){
		List <Trade> trades = repository.findAll();
		
		return trades;
	}
	
	public Trade findById(Long id) {
		Optional<Trade> trade = repository.findById(id);
		
		return trade.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Trade.class.getName()));
		
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
			throw new DataIntegrityException("Não é possivel Deletar uma Estrategia que está relacionada a um Trade ou a uma Catalogação de Estrategia");
		}
	}
	
	public Trade fromDTO(TradeDTO dto) {
		
		return new Trade(dto.getId(), dto.getValorPayOut(), dto.getValorResultado(),dto.getTradeStatus());
	}


}
