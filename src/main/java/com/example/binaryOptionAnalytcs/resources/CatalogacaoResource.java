package com.example.binaryOptionAnalytcs.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.services.CatalogacaoService;

@RestController
@RequestMapping(value = "/catalogacoes")
public class CatalogacaoResource {
	
	@Autowired
	private CatalogacaoService catalogacaoService;
	
	@RequestMapping(value="/buscarAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Catalogacao> catalogacoes = catalogacaoService.findAll();
		
		return ResponseEntity.ok().body(catalogacoes);
	
	}
	
	@RequestMapping(value ="buscarId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Optional<Catalogacao> catalogacao = catalogacaoService.findById(id);
		
		return ResponseEntity.ok().body(catalogacao);
	
	}
}
