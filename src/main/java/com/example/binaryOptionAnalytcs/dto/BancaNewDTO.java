package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import org.hibernate.validator.constraints.Length;

import com.example.binaryOptionAnalytcs.services.validation.BancaInsert;
@BancaInsert
public class BancaNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
		
	private Long valorInicial;
	
	private Long valorAtual;
	
	private Long stopGain;
			
	private Long stopLoss;
	
	private Instant dataCriacao;
	
	@Length(min = 5, max=80, message ="O tamanho deve estar entre 5 e 80" )	
	private String nome;
	
	public BancaNewDTO() {
		
	}
	
	public BancaNewDTO (Long idCliente, Long valorInicial, Long valorAtual, Long stopGain, Long stopLoss, Instant dataCriacao,
			String nome) {
		super();
		
		this.idCliente = idCliente;	
		this.valorInicial = valorInicial;
		this.valorAtual = valorInicial;
		this.stopGain = stopGain;
		this.stopLoss = stopLoss;
		this.dataCriacao = dataCriacao;
		this.nome = nome;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setidCliente(Long id) {
		this.idCliente = id;
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
