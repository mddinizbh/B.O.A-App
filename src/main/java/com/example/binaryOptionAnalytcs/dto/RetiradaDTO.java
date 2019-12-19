package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.entities.Retirada;

public class RetiradaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long valorRetirada;
	private Instant dataRetirada;
	private String descricao;
	
	public RetiradaDTO() {
		
	}

	public RetiradaDTO(Retirada obj) {
		super();
		this.id = obj.getId();
		this.valorRetirada = obj.getValorRetirada();
		this.dataRetirada = obj.getDataRetirada();
		this.descricao = obj.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorRetirada() {
		return valorRetirada;
	}

	public void setValorRetirada(Long valorRetirada) {
		this.valorRetirada = valorRetirada;
	}

	public Instant getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Instant dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
