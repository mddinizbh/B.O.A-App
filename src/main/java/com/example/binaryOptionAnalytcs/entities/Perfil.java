package com.example.binaryOptionAnalytcs.entities;

public enum Perfil {
	
	
	ADMIN(Long.valueOf(2),"ROLE_ADMIN"),
	CLIENTE(Long.valueOf(2),"ROLE_CLIENTE");
	
	private Long cod;
	private String descricao;
	
	 private Perfil(Long cod, String descricao) {
		this.cod= cod;
		this.descricao = descricao;
		
	}
	 
	 public Long getCod() {
		 return cod;
	 }
	 public String getDescricao() {
		 return descricao;
	 }
	 
	 public static Perfil toEnum(Long cod) {
		 for(Perfil x : Perfil.values()) {
			 if(cod.equals(x.getCod()));
			 return x;
		 }
		 throw new IllegalArgumentException("Id invalido; "+cod);
 	 }
	 
	
	
}
