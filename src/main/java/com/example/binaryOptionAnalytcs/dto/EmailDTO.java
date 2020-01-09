package com.example.binaryOptionAnalytcs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {
	
	
	@NotEmpty(message="Preenchimento Obrigatorio")
	@Email(message="Email invalido")
	private String email;

	public EmailDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	};
	
}
