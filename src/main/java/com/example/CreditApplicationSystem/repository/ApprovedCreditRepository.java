package com.example.CreditApplicationSystem.repository;

import com.example.CreditApplicationSystem.entities.ApprovedCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovedCreditRepository extends JpaRepository<ApprovedCredit,Integer> {
}
