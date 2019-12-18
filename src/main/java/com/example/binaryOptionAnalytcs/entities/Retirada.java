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
	
	@ManyToOne
	@JoinColumn(name = "BANCA_ID" )
	private Banca bancaResp = new Banca();
	
	public Retirada() {
		
	}
	
	public Retirada( Long valorRetirada, Instant dataRetirada , String descricao) {
		super();
		
		this.valorRetirada = valorRetirada;
		this.dataRetirada = dataRetirada;
		this.descricao = descricao;
	}

	
	
	public Banca getBancaResp() {
		return bancaResp;
	}


	public void setBancaResp(Banca bancaResp) {
		this.bancaResp = bancaResp;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
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


	public void setDataRetirada(Instant dataAporte) {
		this.dataRetirada = dataAporte;
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



	

}