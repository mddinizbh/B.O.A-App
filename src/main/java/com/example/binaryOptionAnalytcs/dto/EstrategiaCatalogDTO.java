package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;

import com.example.binaryOptionAnalytcs.entities.EstrategiaCatalog;

public class EstrategiaCatalogDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long qtdOperacaoes;
	private Long qtdWin;
	private Long qtdLose;
	private Long qtdMG;
	private Long qtdMGs;
	
	public EstrategiaCatalogDTO() {
		
	}

	public EstrategiaCatalogDTO(EstrategiaCatalog obj) {
		super();
		this.id = obj.getId();
		this.qtdOperacaoes = obj.getQtdOperacaoes();
		this.qtdWin = obj.getQtdWin();
		this.qtdLose = obj.getQtdLose();
		this.qtdMG = obj.getQtdMG();
		this.qtdMGs = obj.getQtdMGs();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQtdOperacaoes() {
		return qtdOperacaoes;
	}

	public void setQtdOperacaoes(Long qtdOperacaoes) {
		this.qtdOperacaoes = qtdOperacaoes;
	}

	public Long getQtdWin() {
		return qtdWin;
	}

	public void setQtdWin(Long qtdWin) {
		this.qtdWin = qtdWin;
	}

	public Long getQtdLose() {
		return qtdLose;
	}

	public void setQtdLose(Long qtdLose) {
		this.qtdLose = qtdLose;
	}

	public Long getQtdMG() {
		return qtdMG;
	}

	public void setQtdMG(Long qtdMG) {
		this.qtdMG = qtdMG;
	}

	public Long getQtdMGs() {
		return qtdMGs;
	}

	public void setQtdMGs(Long qtdMGs) {
		this.qtdMGs = qtdMGs;
	}
	

}
