package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;

import com.example.binaryOptionAnalytcs.entities.Estrategia;

public class EstrategiaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	private String descricao;
	
	
	public EstrategiaDTO() {
		
	}
	public EstrategiaDTO(Estrategia obj) {
		this.setId(obj.getId());
		this.setNome(obj.getNome());
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	

}
