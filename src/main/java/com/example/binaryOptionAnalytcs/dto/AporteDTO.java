package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.binaryOptionAnalytcs.entities.Aporte;

public class AporteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long valorAporte;
	private LocalDate dataAporte;
	
	
	public AporteDTO() {
		
	}


	public AporteDTO(Long id, Long valorAporte, LocalDate dataAporte) {
		super();
		this.id = id;
		this.valorAporte = valorAporte;
		this.dataAporte = dataAporte;
	}


	public AporteDTO(Aporte obj) {
		this.id = obj.getId();
		this.valorAporte = obj.getValorAporte();
		this.dataAporte = obj.getDataAporte();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getValorAporte() {
		return valorAporte;
	}


	public void setValorAporte(Long valorAporte) {
		this.valorAporte = valorAporte;
	}


	public LocalDate getDataAporte() {
		return dataAporte;
	}


	public void setDataAporte(LocalDate dataAporte) {
		this.dataAporte = dataAporte;
	}
	
}
