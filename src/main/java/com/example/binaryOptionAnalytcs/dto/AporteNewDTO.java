package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.services.validation.AporteInsert;

@AporteInsert
public class AporteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idBanca;
	private Long valorAporte;
	private Instant dataAporte;
	
	
	public AporteNewDTO() {
		
	}


	public AporteNewDTO(Long idBanca, Long valorAporte, Instant dataAporte) {
		super();
		this.idBanca = idBanca;
		this.valorAporte = valorAporte;
		this.dataAporte = dataAporte;
	}


	public Long getBancaId() {
		return idBanca;
	}


	public void setBancaId(Long id) {
		this.idBanca = id;
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
