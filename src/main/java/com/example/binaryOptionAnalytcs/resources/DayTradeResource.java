package com.example.binaryOptionAnalytcs.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.DayTrade;
import com.example.binaryOptionAnalytcs.services.DayTradeService;

@RestController
@RequestMapping(value = "/dayTrades")
public class DayTradeResource {
	
	@Autowired
	private DayTradeService DayTradeService;
	
	@RequestMapping(value="/buscarAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<DayTrade> dayTrades = DayTradeService.findAll();
		
		return ResponseEntity.ok().body(dayTrades);
	
	}
	
	@RequestMapping(value ="buscarId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Optional<DayTrade> dayTrade = DayTradeService.findById(id);
		
		return ResponseEntity.ok().body(dayTrade);
	
	}
}
