package com.example.binaryOptionAnalytcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.binaryOptionAnalytcs.entities.DayTrade;

public interface DayTradeRepository extends JpaRepository<DayTrade, Long>{

}
