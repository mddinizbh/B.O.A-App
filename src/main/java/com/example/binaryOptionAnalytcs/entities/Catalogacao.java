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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Catalogacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Instant data;
	private Instant horaInicioCatalog;
	private Instant horafimCatalog;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "catalogacao", cascade = CascadeType.ALL, orphanRemoval = true )
	private List <EstrategiaCatalog> estrategias = new ArrayList<>() ;
    
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "usuario_id" )
	private Usuario usuarioCatalog;
	
	public Catalogacao() {
		
	}

	public Catalogacao(Long iD, String nome, Instant data, Instant horaInicioCatalog, Instant horafimCatalog,
			List<EstrategiaCatalog> estrategias) {
		super();
		id = iD;
		this.nome = nome;
		this.data = data;
		this.horaInicioCatalog = horaInicioCatalog;
		this.horafimCatalog = horafimCatalog;
		this.estrategias = estrategias;
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


	public Instant getData() {
		return data;
	}


	public void setData(Instant data) {
		this.data = data;
	}


	public Instant getHoraInicioCatalog() {
		return horaInicioCatalog;
	}


	public void setHoraInicioCatalog(Instant horaInicioCatalog) {
		this.horaInicioCatalog = horaInicioCatalog;
	}


	public Instant getHorafimCatalog() {
		return horafimCatalog;
	}


	public void setHorafimCatalog(Instant horafimCatalog) {
		this.horafimCatalog = horafimCatalog;
	}


	public List<EstrategiaCatalog> getEstrategias() {
		return estrategias;
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
