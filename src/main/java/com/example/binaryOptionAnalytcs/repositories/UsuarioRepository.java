package com.example.binaryOptionAnalytcs.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.binaryOptionAnalytcs.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
	@Transactional(readOnly=true)
	Usuario findByLogin(String login);
	

}
