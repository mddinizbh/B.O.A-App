package com.example.binaryOptionAnalytcs.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.repositories.ClienteRepository;
import com.example.binaryOptionAnalytcs.security.UsuarioSS;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Cliente usu = repo.findByLogin(login);
		if(usu == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UsuarioSS(usu.getId(),usu.getLogin(),usu.getSenha(),usu.getPerfis());
	}

}
