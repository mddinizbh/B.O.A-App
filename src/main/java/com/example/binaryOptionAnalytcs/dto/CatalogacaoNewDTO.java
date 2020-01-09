package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;

import com.example.binaryOptionAnalytcs.services.validation.CatalogacaoInsert;

@CatalogacaoInsert
public class CatalogacaoNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
	private Long idParMoeda;
	private String nome;
	private String horaInicio;
	private String horaFim;

	
	public CatalogacaoNewDTO () {
		
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horafim) {
		this.horaFim = horafim;
	}

	public Long getIdParMoeda() {
		return idParMoeda;
	}

	public void setIdParMoeda(Long idParMoeda) {
		this.idParMoeda = idParMoeda;
	}


	

}
