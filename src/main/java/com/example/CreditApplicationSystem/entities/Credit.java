package com.example.CreditApplicationSystem.entities;

import com.example.CreditApplicationSystem.constants.Response;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Credit")
@RequiredArgsConstructor
@Data
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id",nullable = false)
    private Client client;

    @Column(name="credit_limit")
    private BigDecimal creditLimit;

    @Column(name= "income",nullable = false)
    private Double income;

    @Column(name= "deposit")
    private Double deposit;

    @Column(name="credit_score")
    private Integer creditScore;

    @Column(name="credit_status")
    private Response creditStatus;
}
