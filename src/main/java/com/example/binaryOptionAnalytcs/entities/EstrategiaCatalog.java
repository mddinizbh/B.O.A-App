package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EstrategiaCatalog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long qtdOperacaoes;
	private Long qtdWin;
	private Long qtdLose;
	private Long qtdMG;
	private Long qtdMGs;
	
	@OneToOne()
	@JoinColumn(name = "ESTRATEGIA_ID")
	private Estrategia estrategia;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "catalogacao_id" )
	private Catalogacao catalogacao;
	


	public EstrategiaCatalog() {
		
	}
	
	public EstrategiaCatalog(Long id, Long qtdOperacaoes, Long qtdWin, Long qtdLose, Long qtdMG, Long qtdMGs) {
		super();
		this.id = id;
		this.qtdOperacaoes = qtdOperacaoes;
		this.qtdWin = qtdWin;
		this.qtdLose = qtdLose;
		this.qtdMG = qtdMG;
		this.qtdMGs = qtdMGs;
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
	
	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	public Catalogacao getCatalogacao() {
		return catalogacao;
	}

	public void setCatalogacao(Catalogacao catalogacao) {
		this.catalogacao = catalogacao;
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
		EstrategiaCatalog other = (EstrategiaCatalog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
		

	
}
