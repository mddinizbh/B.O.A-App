package com.example.binaryOptionAnalytcs.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Retirada;
import com.example.binaryOptionAnalytcs.services.RetiradaService;

@RestController
@RequestMapping(value = "/retiradas")
public class RetiradaResource {
	
	@Autowired
	private RetiradaService retiradaService;
	
	@RequestMapping(value="/buscarAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Retirada> retiradas = retiradaService.findAll();
		
		return ResponseEntity.ok().body(retiradas);
	
	}
	
	@RequestMapping(value ="buscarId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Optional<Retirada> retirada = retiradaService.findById(id);
		
		return ResponseEntity.ok().body(retirada);
	
	}
}
