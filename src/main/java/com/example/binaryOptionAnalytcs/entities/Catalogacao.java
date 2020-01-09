package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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

import org.springframework.lang.NonNull;

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
	private LocalTime horaInicio;
	private LocalTime horaFim;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "catalogacao", cascade = CascadeType.ALL, orphanRemoval = true )
	private List <EstrategiaCatalog> estrategiasCatalogadas = new ArrayList<>();
	
	@NonNull
	@OneToOne
	@JoinColumn(name = "PARMOEDA_ID")
	private ParMoeda parMoeda;
    


	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "cliente_id" )
	private Cliente clienteCatalog;
	
	public Catalogacao() {
		
	}
	public Catalogacao(Long iD, String nome, LocalDate data, String horaInicio, String horaFim
			) {
		super();
		id = iD;
		this.nome = nome;
		this.data = LocalDate.now();
		this.horaInicio = dataFromString(horaInicio);
		this.horaFim = dataFromString(horaFim);
		
	}
	

	public Catalogacao(Long iD, String nome, LocalDate data, String horaInicio, String horaFim,
			List<EstrategiaCatalog> estrategias) {
		super();
		id = iD;
		this.nome = nome;
		this.data = data;
		this.horaInicio = dataFromString(horaInicio);
		this.horaFim = dataFromString(horaFim);
		this.estrategiasCatalogadas = estrategias;
	}

	public Catalogacao(Long iD, String nome, LocalDate data, LocalTime horaInicio, LocalTime horaFim
			) {
		super();
		id = iD;
		this.nome = nome;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getClienteCatalog() {
		return clienteCatalog;
	}


	public void setClienteCatalog(Cliente clienteCatalog) {
		this.clienteCatalog = clienteCatalog;
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


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public LocalTime getHoraFim() {
		return horaFim;
	}


	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
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
	
	private LocalTime dataFromString(String s) {
	
		if(s.contains(":")) {
			Integer hora = Integer.parseInt(s.split(":")[0]);
			Integer minuto = Integer.parseInt(s.split(":")[1]);
			return LocalTime.of(hora, minuto);
		}
		
		return null;
	}



}
