package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.entities.Catalogacao;

public class CatalogacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Instant data;
	private Instant horaInicioCatalog;
	private Instant horafimCatalog;
	
	public CatalogacaoDTO () {
		
	}

	public CatalogacaoDTO(Catalogacao obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.data = obj.getData();
		this.horaInicioCatalog = obj.getHoraInicioCatalog();
		this.horafimCatalog = obj.getHorafimCatalog();
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

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Instant getHoraInicioCatalog() {
		return horaInicioCatalog;
	}

	public void setHoraInicioCatalog(Instant horaInicioCatalog) {
		this.horaInicioCatalog = horaInicioCatalog;
	}

	public Instant getHorafimCatalog() {
		return horafimCatalog;
	}

	public void setHorafimCatalog(Instant horafimCatalog) {
		this.horafimCatalog = horafimCatalog;
	}
	

}
