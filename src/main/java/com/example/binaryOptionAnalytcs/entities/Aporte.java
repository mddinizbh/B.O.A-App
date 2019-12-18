package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long valorAporte;
	private Instant dataAporte;
	
	@ManyToOne
	@JoinColumn(name = "BANCA_ID" )
	private Banca bancaResp = new Banca();
	
	
	
	public Aporte() {
		
	}


	public Banca getBancaResp() {
		return bancaResp;
	}


	public void setBancaResp(Banca bancaResp) {
		this.bancaResp = bancaResp;
	}


	public Aporte( Long valorAporte, Instant dataAporte) {
		super();
		
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aporte other = (Aporte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Instant getDataAporte() {
		return dataAporte;
	}


	public void setDataAporte(Instant dataAporte) {
		this.dataAporte = dataAporte;
	}
	
	

}
