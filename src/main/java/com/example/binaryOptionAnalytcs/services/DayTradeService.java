package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.DayTrade;
import com.example.binaryOptionAnalytcs.repositories.DayTradeRepository;

@Service
public class DayTradeService {
	
	@Autowired
	DayTradeRepository DayTradeRepository;
	
	
	public List<DayTrade> findAll(){
		List <DayTrade> DayTrades = DayTradeRepository.findAll();
		
		return DayTrades;
	}
	
	public Optional<DayTrade> findById(Long id) {
		Optional<DayTrade> DayTrade = DayTradeRepository.findById(id);
		
		return DayTrade;
		
	}

}
