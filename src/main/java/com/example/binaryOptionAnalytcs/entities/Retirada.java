package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Retirada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long valorRetirada;
	private Instant dataRetirada;
	private String descricao;
	
	
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Retirada() {
		
	}


	public Retirada(Long id, Long valorAporte, Instant dataAporte) {
		super();
		this.id = id;
		this.valorRetirada = valorAporte;
		this.dataRetirada = dataAporte;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getValorAporte() {
		return valorRetirada;
	}


	public void setValorAporte(Long valorAporte) {
		this.valorRetirada = valorAporte;
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
		Retirada other = (Retirada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Instant getDataAporte() {
		return dataRetirada;
	}


	public void setDataAporte(Instant dataAporte) {
		this.dataRetirada = dataAporte;
	}
	
	

}