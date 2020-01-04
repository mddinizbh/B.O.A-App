package com.example.binaryOptionAnalytcs.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.binaryOptionAnalytcs.dto.AporteDTO;
import com.example.binaryOptionAnalytcs.dto.AporteNewDTO;
import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.services.AporteService;

@RestController
@RequestMapping(value = "/aportes")
public class AporteResource {
	
	@Autowired
	private AporteService service;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Aporte> aportes = service.findAll();
		
		return ResponseEntity.ok().body(aportes);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Aporte aporte = service.findById(id);
		
		return ResponseEntity.ok().body(aporte);
	
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AporteDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<Aporte> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AporteDTO>  listDto = list.map(obj -> new AporteDTO(obj));
			
	    return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody AporteNewDTO objDto){
		
		Aporte obj = service.fromNewDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping( value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
	
		service.delete(id);
		return ResponseEntity.noContent().build();
			
	}
}
