package com.example.CreditApplicationSystem.repository;

import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Integer> {
    Credit findCreditByClient(Client client);
}
