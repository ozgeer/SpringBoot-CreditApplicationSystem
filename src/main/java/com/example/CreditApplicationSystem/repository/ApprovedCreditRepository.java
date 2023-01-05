package com.example.CreditApplicationSystem.repository;

import com.example.CreditApplicationSystem.entities.ApprovedCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedCreditRepository extends JpaRepository<ApprovedCredit,Integer> {
}
