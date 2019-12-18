package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaCatalogRepository;

@Service
public class EstrategiaCatalogService {
	
	@Autowired
	EstrategiaCatalogRepository estrategiaCatalogRepository;
	
	
	public List<EstrategiaCatalog> findAll(){
		List <EstrategiaCatalog> estrategiaCatalogs = estrategiaCatalogRepository.findAll();
		
		return estrategiaCatalogs;
	}
	
	public Optional<EstrategiaCatalog> findById(Long id) {
		Optional<EstrategiaCatalog> estrategiaCatalog = estrategiaCatalogRepository.findById(id);
		
		return estrategiaCatalog;
		
	}

}
