package com.example.binaryOptionAnalytcs.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.binaryOptionAnalytcs.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	@Transactional(readOnly=true)
	Cliente findByLogin(String login);
	

}
