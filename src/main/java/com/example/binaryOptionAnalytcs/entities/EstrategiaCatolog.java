package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EstrategiaCatolog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long qdtOperacaoes;
	private Long qdtWin;
	private Long qtdLose;
	private Long qtdMG;
	private Long qtdMGs;
	
	@OneToOne()
	@JoinColumn(name = "ESTRATEGIA_ID")
	private Estrategia estrategia;
	
	@ManyToOne
	@JoinColumn(name = "catalogacao_id" )
	private Catalogacao catalogacao;
	
	public EstrategiaCatolog() {
		
	}
	
	public EstrategiaCatolog(Long id, Long qdtOperacaoes, Long qdtWin, Long qtdLose, Long qtdMG, Long qtdMGs) {
		super();
		this.id = id;
		this.qdtOperacaoes = qdtOperacaoes;
		this.qdtWin = qdtWin;
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

	public Long getQdtOperacaoes() {
		return qdtOperacaoes;
	}

	public void setQdtOperacaoes(Long qdtOperacaoes) {
		this.qdtOperacaoes = qdtOperacaoes;
	}

	public Long getQdtWin() {
		return qdtWin;
	}

	public void setQdtWin(Long qdtWin) {
		this.qdtWin = qdtWin;
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
		EstrategiaCatolog other = (EstrategiaCatolog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	
		

	
}
