package com.example.CreditApplicationSystem.repository;

import com.example.CreditApplicationSystem.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit,Integer> {
}
