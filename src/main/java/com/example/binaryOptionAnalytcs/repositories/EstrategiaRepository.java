package com.example.binaryOptionAnalytcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.binaryOptionAnalytcs.entities.Estrategia;

@Repository
public interface EstrategiaRepository extends JpaRepository<Estrategia, Long> {

}
