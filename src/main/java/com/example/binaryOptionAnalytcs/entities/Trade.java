package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Trade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long valorAposta;
	private Long valorPayOut;
	private Long valorResultado;
	
	private char tradeStaus;
	
	@OneToOne()
	@JoinColumn(name = "ESTRATEGIA_ID")
	private Estrategia estrategiaTrade;

	public Trade(Long id, Long valorAposta, Long valorPayOut, Long valorResultado, Estrategia estrategiaTrade) {
		super();
		this.id = id;
		this.valorAposta = valorAposta;
		this.valorPayOut = valorPayOut;
		this.valorResultado = valorResultado;
		this.estrategiaTrade = estrategiaTrade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorAposta() {
		return valorAposta;
	}

	public void setValorAposta(Long valorAposta) {
		this.valorAposta = valorAposta;
	}

	public Long getValorPayOut() {
		return valorPayOut;
	}

	public void setValorPayOut(Long valorPayOut) {
		this.valorPayOut = valorPayOut;
	}

	public Long getValorResultado() {
		return valorResultado;
	}

	public void setValorResultado(Long valorResultado) {
		this.valorResultado = valorResultado;
	}

	public Estrategia getEstrategiaTrade() {
		return estrategiaTrade;
	}

	public void setEstrategiaTrade(Estrategia estrategiaTrade) {
		this.estrategiaTrade = estrategiaTrade;
	}

	public char getTradeStaus() {
		return tradeStaus;
	}

	public void setTradeStaus(char tradeStaus) {
		this.tradeStaus = tradeStaus;
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
		Trade other = (Trade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
