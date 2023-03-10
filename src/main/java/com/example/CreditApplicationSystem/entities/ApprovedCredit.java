package com.example.CreditApplicationSystem.entities;

import com.example.CreditApplicationSystem.constants.Response;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ApprovedCredit")
@RequiredArgsConstructor
@Data
public class ApprovedCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id",nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="credit_id",nullable = false)
    private Credit credit;

    @Column(name="credit_limit")
    private Double creditLimit;

    @Column(name= "income",nullable = false)
    private Double income;

    @Column(name= "deposit")
    private Double deposit;

    @Column(name="credit_score")
    private Integer creditScore;

    @Column(name="credit_status")
    private Response creditStatus;
}
