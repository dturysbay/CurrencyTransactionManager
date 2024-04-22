package com.turysbay.CurrencyTransactionManager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany
    private ArrayList<Transaction> transaction;

    @OneToMany
    private ArrayList<SpendingLimit> spendingLimit;
}
