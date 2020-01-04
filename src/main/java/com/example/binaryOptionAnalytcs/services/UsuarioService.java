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
import com.example.binaryOptionAnalytcs.dto.UsuarioNewDTO;
import com.example.binaryOptionAnalytcs.entities.Usuario;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.repositories.UsuarioRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	
	public List<Usuario> findAll(){
		List <Usuario> usuarios = repository.findAll();
		
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
				
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= Usuario.class.getName();
		
		String msg = messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args); 
		
		return usuario.orElseThrow(() -> new ObjectNotFoundException(msg));
		

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
			throw new DataIntegrityException(messageSource.getMessage(MensagensEnum.ERRO_DELETAR_USUARIO.getMenssagem()));
		}
	}
	

	
	public Usuario fromDTO(UsuarioDTO dto) {
		
		return new Usuario(dto.getId(),dto.getNome(),dto.getEmail(),dto.getDataCriacao());
	}
	public Usuario fromNewDTO( UsuarioNewDTO dto) {
		
		return new Usuario(dto.getId(),dto.getLogin(),dto.getNome(),dto.getEmail(),dto.getSenha());
	}


}
