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

import com.example.binaryOptionAnalytcs.dto.CatalogacaoDTO;
import com.example.binaryOptionAnalytcs.dto.CatalogacaoNewDTO;
import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.entities.ParMoeda;
import com.example.binaryOptionAnalytcs.services.CatalogacaoService;
import com.example.binaryOptionAnalytcs.services.ParMoedaService;

@RestController
@RequestMapping(value = "/catalogacoes")
public class CatalogacaoResource {
	
	@Autowired
	private CatalogacaoService service;
	
	@Autowired
	private ParMoedaService prService;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
				
	List<Catalogacao> catalogacoes = service.findAll();
		
		return ResponseEntity.ok().body(catalogacoes);
	
	}
	
	@RequestMapping(value ="findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
				
		Catalogacao catalogacao = service.findById(id);
		
		return ResponseEntity.ok().body(catalogacao);
	
	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CatalogacaoDTO>> findPage(@RequestParam(value="page", defaultValue ="0") Integer page,
														@RequestParam(value="linesPerPage", defaultValue ="24") Integer linesPerPage,
														@RequestParam(value="orderBy", defaultValue ="nome") String orderBy, 
														@RequestParam(value="direction", defaultValue ="ASC") String direction) {
		
		Page<Catalogacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CatalogacaoDTO>  listDto = list.map(obj -> new CatalogacaoDTO(obj));
			
		 return ResponseEntity.ok().body(listDto);
		
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody CatalogacaoNewDTO objDto){
		
		Catalogacao obj = service.fromNewDTO(objDto);
		ParMoeda par = prService.findById(objDto.getIdParMoeda());
		obj.setParMoeda(par);
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping( value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CatalogacaoDTO objDto, @PathVariable Long id){
		Catalogacao obj = service.fromDTO(objDto);
		
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
