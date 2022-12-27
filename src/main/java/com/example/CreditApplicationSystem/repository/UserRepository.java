package com.example.CreditApplicationSystem.repository;

import com.example.CreditApplicationSystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client,Long> {
    Boolean existsByCitizenId(String citizenId);
    Client findClientByCitizenId(String citizenId);
}
