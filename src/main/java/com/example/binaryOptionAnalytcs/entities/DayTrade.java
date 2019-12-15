package com.example.binaryOptionAnalytcs.entities;


import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class DayTrade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant data;
	private Long valorReal;
	private Long valorPorc;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "DAYTRADE_ID")
	private List <Trade> trades = new ArrayList<>();

	public DayTrade(Long id, Instant data, Long valorReal, Long valorPorc, List<Trade> trades) {
		super();
		this.id = id;
		this.data = data;
		this.valorReal = valorReal;
		this.valorPorc = valorPorc;
		this.trades = trades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Long getValorReal() {
		return valorReal;
	}

	public void setValorReal(Long valorReal) {
		this.valorReal = valorReal;
	}

	public Long getValorPorc() {
		return valorPorc;
	}

	public void setValorPorc(Long valorPorc) {
		this.valorPorc = valorPorc;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
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
		DayTrade other = (DayTrade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
	
}
