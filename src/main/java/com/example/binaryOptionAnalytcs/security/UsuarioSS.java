package com.example.binaryOptionAnalytcs.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.binaryOptionAnalytcs.entities.Perfil;

public class UsuarioSS implements UserDetails {
	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String login;
	private String senha;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioSS() {
		
	}
	public UsuarioSS(Long id, String login, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		
		
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	public boolean hasHole(Perfil perfil) {
		
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
