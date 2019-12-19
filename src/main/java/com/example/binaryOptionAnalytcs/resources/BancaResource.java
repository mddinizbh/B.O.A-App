package com.example.binaryOptionAnalytcs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.services.BancaService;

@RestController
@RequestMapping(value = "/bancas")
public class BancaResource {
	
	@Autowired
	private BancaService bancaService;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Banca> bancas = bancaService.findAll();
		
		return ResponseEntity.ok().body(bancas);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Banca banca = bancaService.findById(id);
		
		return ResponseEntity.ok().body(banca);
	
	}
}
