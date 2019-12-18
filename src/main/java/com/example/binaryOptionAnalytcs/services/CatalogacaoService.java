package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.repositories.CatalogacaoRepository;

@Service
public class CatalogacaoService {
	
	@Autowired
	CatalogacaoRepository catalogacaoRepository;
	
	
	public List<Catalogacao> findAll(){
		List <Catalogacao> catalogacaos = catalogacaoRepository.findAll();
		
		return catalogacaos;
	}
	
	public Optional<Catalogacao> findById(Long id) {
		Optional<Catalogacao> catalogacao = catalogacaoRepository.findById(id);
		
		return catalogacao;
		
	}

}
