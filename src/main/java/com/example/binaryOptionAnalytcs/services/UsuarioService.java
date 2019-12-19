package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.UsuarioDTO;
import com.example.binaryOptionAnalytcs.entities.Usuario;
import com.example.binaryOptionAnalytcs.repositories.UsuarioRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	
	public List<Usuario> findAll(){
		List <Usuario> usuarios = repository.findAll();
		
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
				
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));

	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Usuario update(Usuario obj) {
	
		findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Deletar uma Estrategia que está relacionada a um Trade ou a uma Catalogação de Estrategia");
		}
	}
	

	
	public Usuario fromDTO(UsuarioDTO dto) {
		
		return new Usuario(dto.getId(),dto.getLogin(), dto.getNome(), dto.getEmail(), dto.getSenha(),dto.getDataCriacao());
	}


}
