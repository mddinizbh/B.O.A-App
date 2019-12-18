package com.example.binaryOptionAnalytcs.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Trade;
import com.example.binaryOptionAnalytcs.services.TradeService;

@RestController
@RequestMapping(value = "/trades")
public class TradeResource {
	
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping(value="/buscarAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Trade> trades = tradeService.findAll();
		
		return ResponseEntity.ok().body(trades);
	
	}
	
	@RequestMapping(value ="buscarId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Optional<Trade> trade = tradeService.findById(id);
		
		return ResponseEntity.ok().body(trade);
	
	}
}
