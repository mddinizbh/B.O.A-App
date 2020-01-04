package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;

import com.example.binaryOptionAnalytcs.entities.ParMoeda;

public class ParMoedaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
		
		private Long id;
		
		private String nome;

		public ParMoedaDTO() {
			
		}
		
		public ParMoedaDTO(Long id, String nome) {
			this.id = id;
			this.nome = nome;
		}
		
		public ParMoedaDTO(ParMoeda obj) {
			this.id = obj.getId();
			this.nome = obj.getNome();
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

	}


