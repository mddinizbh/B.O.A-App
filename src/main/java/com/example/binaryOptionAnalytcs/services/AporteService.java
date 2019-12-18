package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Aporte;
import com.example.binaryOptionAnalytcs.repositories.AporteRepository;

@Service
public class AporteService {
	
	@Autowired
	AporteRepository usuarioRepository;
	
	
	public List<Aporte> findAll(){
		List <Aporte> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
	public Optional<Aporte> findById(Long id) {
		Optional<Aporte> usuario = usuarioRepository.findById(id);
		
		return usuario;
		
	}

}
