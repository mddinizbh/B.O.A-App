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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Banca implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long valorInicial;
	private Long valorAtual;
	private Long stopGain;
	private Long stopLoss;
	
	private Instant dataCricao;
	
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BANCA_ID")
	private List <Aporte> aportes = new ArrayList<>() ; 
    
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BANCA_ID")
	private List <Retirada> retiradas = new ArrayList<>() ; 
	
	  
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BANCA_ID")
    private List<DayTrade> dayTrades = new ArrayList<>(); 
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID" )
	private Usuario usuarioBanca;
	
	

	public Banca () {
		
	}

	public Banca(Long id, Long valorInicial, Long valorAtual, Long stopGain, Long stopLoss, Instant dataCricao,
			String nome, List<Aporte> aportes, List<Retirada> retiradas, List<DayTrade> dayTrades) {
		super();
		this.id = id;
		this.valorInicial = valorInicial;
		this.valorAtual = valorAtual;
		this.stopGain = stopGain;
		this.stopLoss = stopLoss;
		this.dataCricao = dataCricao;
		this.nome = nome;
		this.aportes = aportes;
		this.retiradas = retiradas;
		this.dayTrades = dayTrades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Long valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Long getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Long valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Long getStopGain() {
		return stopGain;
	}

	public void setStopGain(Long stopGain) {
		this.stopGain = stopGain;
	}

	public Long getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(Long stopLoss) {
		this.stopLoss = stopLoss;
	}

	public Instant getDataCricao() {
		return dataCricao;
	}

	public void setDataCricao(Instant dataCricao) {
		this.dataCricao = dataCricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aporte> getAportes() {
		return aportes;
	}

	public void setAportes(List<Aporte> aportes) {
		this.aportes = aportes;
	}

	public List<Retirada> getRetiradas() {
		return retiradas;
	}

	public void setRetiradas(List<Retirada> retiradas) {
		this.retiradas = retiradas;
	}

	public List<DayTrade> getDayTrades() {
		return dayTrades;
	}

	public void setDayTrades(List<DayTrade> dayTrades) {
		this.dayTrades = dayTrades;
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
		Banca other = (Banca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
