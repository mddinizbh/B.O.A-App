package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.binaryOptionAnalytcs.entities.Catalogacao;

public class CatalogacaoNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String nome;
	private LocalDate data;
	private LocalDate horaInicioCatalog;
	private LocalDate horafimCatalog;
	
	public CatalogacaoNewDTO () {
		
	}

	public CatalogacaoNewDTO(Catalogacao obj) {
		super();
		
		this.nome = obj.getNome();
		this.data = obj.getData();
		this.horaInicioCatalog = obj.getHoraInicioCatalog();
		this.horafimCatalog = obj.getHorafimCatalog();
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

	public LocalDate getHoraInicioCatalog() {
		return horaInicioCatalog;
	}

	public void setHoraInicioCatalog(LocalDate horaInicioCatalog) {
		this.horaInicioCatalog = horaInicioCatalog;
	}

	public LocalDate getHorafimCatalog() {
		return horafimCatalog;
	}

	public void setHorafimCatalog(LocalDate horafimCatalog) {
		this.horafimCatalog = horafimCatalog;
	}
	

}
