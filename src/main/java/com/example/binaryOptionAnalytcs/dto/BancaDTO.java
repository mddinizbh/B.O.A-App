package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

public class BancaDTO implements Serializable{

		private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long valorInicial;
	private Long valorAtual;
	private Long stopGain;
	private Long stopLoss;
	private Instant dataCriacao;
	private String nome;
	
	
	public BancaDTO() {
		
	}
	
	public BancaDTO (Long id, Long valorInicial, Long valorAtual, Long stopGain, Long stopLoss, Instant dataCriacao,
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

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
