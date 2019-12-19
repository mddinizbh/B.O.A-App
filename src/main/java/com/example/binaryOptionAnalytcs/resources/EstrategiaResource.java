package com.example.binaryOptionAnalytcs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.example.binaryOptionAnalytcs.dto.EstrategiaDTO;
import com.example.binaryOptionAnalytcs.entities.Estrategia;
import com.example.binaryOptionAnalytcs.services.EstrategiaService;

@RestController
@RequestMapping(value = "/estrategias")
public class EstrategiaResource {
	
	@Autowired
	EstrategiaService service;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Estrategia> list = service.findAll();
	List<EstrategiaDTO>  listDto = list.stream().map(obj -> new EstrategiaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		EstrategiaDTO dto = new EstrategiaDTO(service.findById(id));
		
		return ResponseEntity.ok().body(dto);
	
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EstrategiaDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<Estrategia> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EstrategiaDTO>  listDto = list.map(obj -> new EstrategiaDTO(obj));
			
		 return ResponseEntity.ok().body(listDto);
		
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody EstrategiaDTO objDto){
		
		Estrategia obj = service.fromDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping( value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EstrategiaDTO objDto, @PathVariable Long id){
		Estrategia obj = service.fromDTO(objDto);
		
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
