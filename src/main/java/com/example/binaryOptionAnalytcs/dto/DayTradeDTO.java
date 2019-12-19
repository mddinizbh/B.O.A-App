package com.example.binaryOptionAnalytcs.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.binaryOptionAnalytcs.entities.DayTrade;

public class DayTradeDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private Long id;
		private Instant data;
		private Long valorReal;
		private Long valorPorc;
		
		public DayTradeDTO() {
			
		}

		public DayTradeDTO(DayTrade obj) {
			super();
			this.id = obj.getId();
			this.data = obj.getData();
			this.valorReal = obj.getValorReal();
			this.valorPorc = obj.getValorPorc();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Instant getData() {
			return data;
		}

		public void setData(Instant data) {
			this.data = data;
		}

		public Long getValorReal() {
			return valorReal;
		}

		public void setValorReal(Long valorReal) {
			this.valorReal = valorReal;
		}

		public Long getValorPorc() {
			return valorPorc;
		}

		public void setValorPorc(Long valorPorc) {
			this.valorPorc = valorPorc;
		}
		

}
