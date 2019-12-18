package com.example.binaryOptionAnalytcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.binaryOptionAnalytcs.entities.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long>{

}
