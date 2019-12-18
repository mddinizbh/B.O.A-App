package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Estrategia;
import com.example.binaryOptionAnalytcs.repositories.EstrategiaRepository;

@Service
public class EstrategiaService {
	
	@Autowired
	EstrategiaRepository estrategiaRepository;
	
	
	public List<Estrategia> findAll(){
		List <Estrategia> estrategias = estrategiaRepository.findAll();
		
		return estrategias;
	}
	
	public Optional<Estrategia> findById(Long id) {
		Optional<Estrategia> estrategia = estrategiaRepository.findById(id);
		
		return estrategia;
		
	}

}
