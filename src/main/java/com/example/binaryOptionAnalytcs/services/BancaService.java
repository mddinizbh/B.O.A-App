package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.repositories.BancaRepository;

@Service
public class BancaService {
	
	@Autowired
	BancaRepository bancaRepository;
	
	
	public List<Banca> findAll(){
		List <Banca> bancas = bancaRepository.findAll();
		
		return bancas;
	}
	
	public Optional<Banca> findById(Long id) {
		Optional<Banca> banca = bancaRepository.findById(id);
		
		return banca;
		
	}

}
