package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Usuario;
import com.example.binaryOptionAnalytcs.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll(){
		List <Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
	public Optional<Usuario> findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario;
		
	}

}
