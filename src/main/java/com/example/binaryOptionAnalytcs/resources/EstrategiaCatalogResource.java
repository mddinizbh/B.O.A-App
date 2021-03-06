package com.example.binaryOptionAnalytcs.resources;

import java.net.URI;
import java.util.List;

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

import com.example.binaryOptionAnalytcs.dto.EstrategiaCatalogDTO;
import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.services.EstrategiaCatalogService;

@RestController
@RequestMapping(value = "/estrategiascatalogs")
public class EstrategiaCatalogResource {
	
	@Autowired
	private EstrategiaCatalogService service;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<EstrategiaCatalog> estrategiasCatalogs = service.findAll();
		
		return ResponseEntity.ok().body(estrategiasCatalogs);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		EstrategiaCatalog estrategiaCatalog = service.findById(id);
		
		return ResponseEntity.ok().body(estrategiaCatalog);
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EstrategiaCatalogDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<EstrategiaCatalog> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EstrategiaCatalogDTO>  listDto = list.map(obj -> new EstrategiaCatalogDTO(obj));
			
		 return ResponseEntity.ok().body(listDto);
		
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody EstrategiaCatalogDTO objDto){
		
		EstrategiaCatalog obj = service.fromDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping( value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EstrategiaCatalogDTO objDto, @PathVariable Long id){
		EstrategiaCatalog obj = service.fromDTO(objDto);
		
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
