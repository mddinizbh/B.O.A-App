package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Catalogacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate data;
	private LocalDate horaInicioCatalog;
	private LocalDate horafimCatalog;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "catalogacao", cascade = CascadeType.ALL, orphanRemoval = true )
	private List <EstrategiaCatalog> estrategiasCatalogadas = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "PARMOEDA_ID")
	private ParMoeda parMoeda;
    


	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "usuario_id" )
	private Usuario usuarioCatalog;
	
	public Catalogacao() {
		
	}
	
	public Catalogacao(Long iD, String nome, LocalDate data, LocalDate horaInicioCatalog, LocalDate horafimCatalog
			) {
		super();
		id = iD;
		this.nome = nome;
		this.data = data;
		this.horaInicioCatalog = horaInicioCatalog;
		this.horafimCatalog = horafimCatalog;
		
	}

	public Catalogacao(Long iD, String nome, LocalDate data, LocalDate horaInicioCatalog, LocalDate horafimCatalog,
			List<EstrategiaCatalog> estrategias) {
		super();
		id = iD;
		this.nome = nome;
		this.data = data;
		this.horaInicioCatalog = horaInicioCatalog;
		this.horafimCatalog = horafimCatalog;
		this.estrategiasCatalogadas = estrategias;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Usuario getUsuarioCatalog() {
		return usuarioCatalog;
	}


	public void setUsuarioCatalog(Usuario usuarioCatalog) {
		this.usuarioCatalog = usuarioCatalog;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalDate getHoraInicioCatalog() {
		return horaInicioCatalog;
	}


	public void setHoraInicioCatalog(LocalDate horaInicioCatalog) {
		this.horaInicioCatalog = horaInicioCatalog;
	}


	public LocalDate getHorafimCatalog() {
		return horafimCatalog;
	}


	public void setHorafimCatalog(LocalDate horafimCatalog) {
		this.horafimCatalog = horafimCatalog;
	}


	public List<EstrategiaCatalog> getEstrategiasCatalogadas() {
		return estrategiasCatalogadas;
	}


	public ParMoeda getParMoeda() {
		return parMoeda;
	}
	
	public void setParMoeda(ParMoeda parMoeda) {
		this.parMoeda = parMoeda;
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
		Catalogacao other = (Catalogacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
