package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

public class AporteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long valorAporte;
	private Instant dataAporte;
	
	
	public AporteDTO() {
		
	}


	public AporteDTO(Long id, Long valorAporte, Instant dataAporte) {
		super();
		this.id = id;
		this.valorAporte = valorAporte;
		this.dataAporte = dataAporte;
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


	public Instant getDataAporte() {
		return dataAporte;
	}


	public void setDataAporte(Instant dataAporte) {
		this.dataAporte = dataAporte;
	}
	
}
