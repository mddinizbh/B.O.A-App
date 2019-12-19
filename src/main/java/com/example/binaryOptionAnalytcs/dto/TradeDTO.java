package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;

import com.example.binaryOptionAnalytcs.entities.Trade;

public class TradeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long valorAposta;
	private Long valorPayOut;
	private Long valorResultado;
	private char tradeStatus;	
	
	public TradeDTO() {
		
	}

	public TradeDTO(Trade obj) {
		super();
		this.id = obj.getId();
		this.valorAposta = obj.getValorAposta();
		this.valorPayOut = obj.getValorPayOut();
		this.valorResultado = obj.getValorResultado();
		this.tradeStatus = obj.getTradeStatus();
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

	public char getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(char tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	

}
