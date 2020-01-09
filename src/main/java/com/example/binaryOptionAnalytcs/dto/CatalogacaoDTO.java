package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.binaryOptionAnalytcs.entities.Catalogacao;

public class CatalogacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFImg;
	
	public CatalogacaoDTO () {
		
	}

	public CatalogacaoDTO(Catalogacao obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.data = obj.getData();
		this.horaInicio = obj.getHoraFim();
		this.horaFImg = obj.getHoraInicio();
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFImg;
	}

	public void setHoraFim(LocalTime horaFImg) {
		this.horaFImg = horaFImg;
	}
	

}
