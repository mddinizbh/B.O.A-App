package com.example.binaryOptionAnalytcs.entities;


import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Banca implements Serializable{

	
	public Usuario getUsuarioBanca() {
		return usuarioBanca;
	}

	public void setUsuarioBanca(Usuario usuarioBanca) {
		this.usuarioBanca = usuarioBanca;
	}

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
	
	private Instant dataCriacao;
	
	private String nome;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bancaResp",  orphanRemoval = true )
	private List <Aporte> aportes = new ArrayList<>() ; 
    
	@JsonManagedReference
	@OneToMany(mappedBy = "bancaResp",  orphanRemoval = true )
	private List <Retirada> retiradas = new ArrayList<>() ; 
	
	  
	@JsonManagedReference
	@OneToMany(mappedBy = "bancaResp",  orphanRemoval = true )
    private List<DayTrade> dayTrades = new ArrayList<>(); 
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "USUARIO_ID" )
	private Usuario usuarioBanca = new Usuario();
	
	

	public Banca () {
		
	}

	public Banca (Long id, Long valorInicial, Long valorAtual, Long stopGain, Long stopLoss, Instant dataCriacao,
			String nome) {
		super();
		this.id = id;	
		this.valorInicial = valorInicial;
		this.valorAtual = valorAtual;
		this.stopGain = stopGain;
		this.stopLoss = stopLoss;
		this.dataCriacao = dataCriacao;
		this.nome = nome;

	}
		
	public Banca (Long id, Long valorInicial, Long valorAtual, Long stopGain, Long stopLoss, Instant dataCriacao,
			String nome, List<Aporte> aportes, List<Retirada> retiradas, List<DayTrade> dayTrades, Usuario usuarioBanca) {
		super();
		this.id = id;	
		this.valorInicial = valorInicial;
		this.valorAtual = valorAtual;
		this.stopGain = stopGain;
		this.stopLoss = stopLoss;
		this.dataCriacao = dataCriacao;
		this.nome = nome;
		this.aportes = aportes;
		this.retiradas = retiradas;
		this.dayTrades = dayTrades;
		this.usuarioBanca = usuarioBanca;
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

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCricao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
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

	public List<Retirada> getRetiradas() {
		return retiradas;
	}

	public List<DayTrade> getDayTrades() {
		return dayTrades;
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
