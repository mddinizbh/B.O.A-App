package com.example.binaryOptionAnalytcs.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CLIENTE", uniqueConstraints =
	@UniqueConstraint(columnNames={"CLIENTE", "CLIENTE_LOGIN"}) )

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENTE")
	private Long id;
	
	private String nome;
		
	@JsonIgnore
	private String email;
	
	@Column(name = "CLIENTE_LOGIN")
	private String login;
	
	private String senha;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clienteBanca", orphanRemoval = true )
	private List<Banca> banca;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "clienteCatalog", orphanRemoval = true )
	private List<Catalogacao> catalogacao = new ArrayList<>() ; 
	
	private Instant dataCriacao;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	
	private Set<Long> perfis = new HashSet<>();
	
	
	
	
	public Set<Perfil> getPerfis() {
		
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}



	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}



	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}
	

	
	public Cliente( Long id, String login,String nome,String email,String senha) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCriacao = Instant.now();
		addPerfil(Perfil.CLIENTE);
	}
		
	public Cliente(Long id, String nome, String email, Instant dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataCriacao = dataCriacao;
		addPerfil(Perfil.CLIENTE);
	
	}
	
	public Cliente(Long id, String login, String nome, String email, String senha, List<Banca> banca, List<Catalogacao> catalogacao,
			Instant dataCriacao) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.banca = banca;
		this.catalogacao = catalogacao;
		this.dataCriacao = dataCriacao;
		addPerfil(Perfil.CLIENTE);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Banca> getBanca() {
		return banca;
	}

	public List<Catalogacao> getCatalogacao() {
		return catalogacao;
	}
	
	public Instant getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}


	
 
}
