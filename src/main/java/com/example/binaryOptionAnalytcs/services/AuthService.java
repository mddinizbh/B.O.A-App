package com.example.binaryOptionAnalytcs.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.repositories.ClienteRepository;
import com.example.binaryOptionAnalytcs.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
			
		}
		
		String novaSenha = newPassword();
		cliente.setSenha(bc.encode(novaSenha));
		
		clienteRepository.save(cliente);
		emailService.sendNewPassword(cliente, novaSenha);
		
	}
	
	private String newPassword() {
		char [] vet = new char[10];
		for(int i=0;i<10;i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 1) {
			return (char)(rand.nextInt(9)+49);
		}else if(opt==2) {
			return (char)(rand.nextInt(26)+65);
		}else {
			return (char)(rand.nextInt(26)+97);
		}
	}
	
	
}
