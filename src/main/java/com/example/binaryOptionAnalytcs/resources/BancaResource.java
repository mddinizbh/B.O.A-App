package com.example.binaryOptionAnalytcs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.example.binaryOptionAnalytcs.dto.BancaDTO;
import com.example.binaryOptionAnalytcs.dto.BancaNewDTO;
import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.services.BancaService;

@RestController
@RequestMapping(value = "/bancas")
public class BancaResource {
	
	@Autowired
	private BancaService service;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<List <BancaDTO>> findAll() {
		
		List<Banca> bancas = service.findAll();
		List<BancaDTO> bancasDto = bancas.stream().map(obj -> new BancaDTO(obj)).collect(Collectors.toList());	
		return ResponseEntity.ok().body(bancasDto);
		
	}
	
	@RequestMapping(value="/findAllByCliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<List <BancaDTO>> findAllByCliente(@PathVariable Long id) {
				
		List<Banca> bancas = service.findAllByCliente(id);
		List<BancaDTO> bancasDto = bancas.stream().map(obj -> new BancaDTO(obj)).collect(Collectors.toList());	
		return ResponseEntity.ok().body(bancasDto);
		
	}
	
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<BancaDTO> findById(@PathVariable Long id) {
				
		BancaDTO banca =  new BancaDTO(service.findById(id));
		
		return ResponseEntity.ok().body(banca);
	
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<BancaDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<Banca> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<BancaDTO>  listDto = list.map(obj -> new BancaDTO(obj));
			
	    return ResponseEntity.ok().body(listDto);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody BancaNewDTO objDto){
		
		Banca obj = service.fromNewDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}
	@RequestMapping( value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody BancaDTO objDto, @PathVariable Long id){
		Banca obj = service.fromDTO(objDto);
		
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
			
	}
	@RequestMapping( value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
	
		service.delete(id);
		return ResponseEntity.noContent().build();
			
	}
	
}
