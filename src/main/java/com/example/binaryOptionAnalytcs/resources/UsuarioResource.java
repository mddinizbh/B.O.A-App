package com.example.binaryOptionAnalytcs.resources;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryOptionAnalytcs.entities.Banca;
import com.example.binaryOptionAnalytcs.entities.Catalogacao;
import com.example.binaryOptionAnalytcs.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll() {
		Usuario u = new Usuario(1L, "Joao", "@gmail.com", "120389",new ArrayList<Banca>(),new ArrayList<Catalogacao>(), null);
		return ResponseEntity.ok().body(u);
	}
}
