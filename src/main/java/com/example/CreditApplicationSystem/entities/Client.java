package com.example.CreditApplicationSystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Client",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"citizenId"},name = "ux_citizen_id")
})
@Data
@RequiredArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    @Column(name="citizenId",nullable = false,length = 11)
    private Long citizenId;

    @Column(name="name",nullable = false,length = 50)
    private String name;

    @Column(name="lastName",nullable = false,length = 50)
    private String lastName;

    @Column(name="phoneNumber",nullable = true,length = 20)
    private String phoneNumber;

    @Column(name="income")
    private Integer income;

    @Column(name="deposit")
    private Integer deposit;

    @Column(name="birthDate")
    private LocalDate birthDate;

    @Column(name="creditScore")
    private int creditScore;

    @Column(name="isActive")
    private boolean isActive=true;
}
