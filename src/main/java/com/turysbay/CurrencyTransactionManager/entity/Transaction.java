package com.turysbay.CurrencyTransactionManager.entity;

import com.turysbay.CurrencyTransactionManager.enums.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal amount;
    private Currency currency;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
