package com.example.binaryOptionAnalytcs.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.dto.ClienteDTO;
import com.example.binaryOptionAnalytcs.dto.ClienteNewDTO;
import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.entities.Perfil;
import com.example.binaryOptionAnalytcs.enuns.MensagensEnum;
import com.example.binaryOptionAnalytcs.repositories.ClienteRepository;
import com.example.binaryOptionAnalytcs.repositories.MessageByLocaleRepository;
import com.example.binaryOptionAnalytcs.security.UsuarioSS;
import com.example.binaryOptionAnalytcs.services.exceptions.AuthorizationException;
import com.example.binaryOptionAnalytcs.services.exceptions.DataIntegrityException;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private MessageByLocaleRepository messageSource;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	
	public List<Cliente> findAll(){
		List <Cliente> usuarios = repository.findAll();
		
		return usuarios;
	}
	
	public Cliente findById(Long id) {

		
		UsuarioSS usuarioLogado = UserService.authenticado();
		
		if((usuarioLogado == null || !id.equals(usuarioLogado.getId())&&!usuarioLogado.hasHole(Perfil.ADMIN))) {
			throw new AuthorizationException(messageSource.getMessage(MensagensEnum.USUARIO_NAO_AUTORIZADO.getMenssagem()));
		}
		
		Optional<Cliente> usuario = repository.findById(usuarioLogado.getId());
		
		
		Object [] args = new Object[10];
		args[0]=id;
		args[1]= Cliente.class.getName();
				
		return usuario.orElseThrow(() -> new ObjectNotFoundException(messageSource.getMessage(MensagensEnum.TIPO_NAO_ENCONTRADO.getMenssagem(),args)));
		

	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		
		return repository.findAll(pageRequest);
	}
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cliente update(Cliente obj) {
	
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
	

	
	public Cliente fromDTO(ClienteDTO dto) {
		
		return new Cliente(dto.getId(),dto.getNome(),dto.getEmail(),dto.getDataCriacao());
	}
	public Cliente fromNewDTO( ClienteNewDTO dto) {
		
		return new Cliente(dto.getId(),dto.getLogin(),dto.getNome(),dto.getEmail(),passwordEnconder.encode(dto.getSenha()));
	}


}
