package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Trade;
import com.example.binaryOptionAnalytcs.repositories.TradeRepository;

@Service
public class TradeService {
	
	@Autowired
	TradeRepository tradeRepository;
	
	
	public List<Trade> findAll(){
		List <Trade> trades = tradeRepository.findAll();
		
		return trades;
	}
	
	public Optional<Trade> findById(Long id) {
		Optional<Trade> trade = tradeRepository.findById(id);
		
		return trade;
		
	}

}
