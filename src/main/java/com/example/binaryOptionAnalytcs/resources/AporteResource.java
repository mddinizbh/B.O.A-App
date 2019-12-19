package com.example.binaryOptionAnalytcs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.services.AporteService;

@RestController
@RequestMapping(value = "/aportes")
public class AporteResource {
	
	@Autowired
	private AporteService aporteService;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Aporte> aportes = aporteService.findAll();
		
		return ResponseEntity.ok().body(aportes);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Aporte aporte = aporteService.findById(id);
		
		return ResponseEntity.ok().body(aporte);
	
	}
}
