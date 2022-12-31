package com.example.CreditApplicationSystem.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="Client")
//,uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"citizenId"},name = "ux_citizen_id")})
@Data
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="citizen_id",nullable = false,length = 11)
    private String citizenId;

    @Column(name="name",nullable = false,length = 50)
    private String name;

    @Column(name="last_name",nullable = false,length = 50)
    private String lastName;

    @Column(name="phone_number",nullable = true,length = 20)
    private String phoneNumber;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="is_active")
    private boolean isActive=true;
}
