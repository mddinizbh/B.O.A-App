package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.entities.Cliente;
import com.example.binaryOptionAnalytcs.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
			
	private String nome;
		
	private String email;
	
    private String login;

    private String senha;

	private Instant dataCriacao;
	
	public ClienteNewDTO() {
		
	}
	
	public ClienteNewDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
		this.dataCriacao = Instant.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}



}
