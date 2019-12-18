package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Retirada;
import com.example.binaryOptionAnalytcs.repositories.RetiradaRepository;

@Service
public class RetiradaService {
	
	@Autowired
	RetiradaRepository retiradaRepository;
	
	
	public List<Retirada> findAll(){
		List <Retirada> retiradas = retiradaRepository.findAll();
		
		return retiradas;
	}
	
	public Optional<Retirada> findById(Long id) {
		Optional<Retirada> retirada = retiradaRepository.findById(id);
		
		return retirada;
		
	}

}
