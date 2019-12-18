package com.example.binaryOptionAnalytcs.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.services.EstrategiaCatalogService;

@RestController
@RequestMapping(value = "/estrategiasCatalogs")
public class EstrategiaCatalogResource {
	
	@Autowired
	private EstrategiaCatalogService estrategiaCatalogService;
	
	@RequestMapping(value="/buscarAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<EstrategiaCatalog> estrategiasCatalogs = estrategiaCatalogService.findAll();
		
		return ResponseEntity.ok().body(estrategiasCatalogs);
	
	}
	
	@RequestMapping(value ="buscarId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Optional<EstrategiaCatalog> estrategiaCatalog = estrategiaCatalogService.findById(id);
		
		return ResponseEntity.ok().body(estrategiaCatalog);
	
	}
}
