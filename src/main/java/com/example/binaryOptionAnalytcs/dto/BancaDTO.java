package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.entities.Banca;

public class BancaDTO implements Serializable{

		private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long valorInicial;
	private Long valorAtual;
	private Long stopGain;
	private Long stopLoss;
	private Long idUsuario;
	private String nome;
	private Instant dataCriacao;
	
	
	public BancaDTO() {
		
	}
	public BancaDTO(Banca obj) {
		this.id = obj.getId();
		this.valorInicial = obj.getValorInicial();
		this.valorAtual = obj.getValorAtual();
		this.stopGain = obj.getStopGain();
		this.stopLoss = obj.getStopLoss();
		this.nome = obj.getNome();
		this.dataCriacao = obj.getDataCriacao();
		this.idUsuario = obj.getClienteBanca().getId();
		
		
	}

		
	public BancaDTO (Long id, Long valorInicial, Long valorAtual, Long stopGain, 
					 Long stopLoss, Instant dataCriacao,	String nome) {
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
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Instant getDataCriacao() {
		return dataCriacao;
	}
	
	
	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	

}
