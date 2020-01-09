package com.example.binaryOptionAnalytcs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.binaryOptionAnalytcs.entities.Banca;

public interface BancaRepository extends JpaRepository<Banca, Long> {
	  
	  @Query("SELECT obj FROM Banca obj WHERE obj.clienteBanca.id = :id")
	  
	  List<Banca> FindAllByCliente(@Param("id")Long id);
         
}
