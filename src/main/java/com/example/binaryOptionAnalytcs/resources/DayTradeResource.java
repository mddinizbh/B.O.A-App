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

import com.example.binaryOptionAnalytcs.dto.DayTradeDTO;
import com.example.binaryOptionAnalytcs.entities.DayTrade;
import com.example.binaryOptionAnalytcs.services.DayTradeService;

@RestController
@RequestMapping(value = "/dayTrades")
public class DayTradeResource {
	
	@Autowired
	private DayTradeService service;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<DayTrade> dayTrades = service.findAll();
		
		return ResponseEntity.ok().body(dayTrades);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		DayTrade dayTrade = service.findById(id);
		
		return ResponseEntity.ok().body(dayTrade);
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<DayTradeDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<DayTrade> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<DayTradeDTO>  listDto = list.map(obj -> new DayTradeDTO(obj));
			
		 return ResponseEntity.ok().body(listDto);
		
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody DayTradeDTO objDto){
		
		DayTrade obj = service.fromDTO(objDto);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping( value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody DayTradeDTO objDto, @PathVariable Long id){
		DayTrade obj = service.fromDTO(objDto);
		
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
