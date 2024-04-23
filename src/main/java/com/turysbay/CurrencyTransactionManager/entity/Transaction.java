package com.turysbay.CurrencyTransactionManager.entity;

import com.turysbay.CurrencyTransactionManager.enums.Category;
import com.turysbay.CurrencyTransactionManager.enums.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal baseAmount;
    private BigDecimal targetAmount;
    private Double exchangeRate;

    @Enumerated(EnumType.STRING)
    private Currency baseCurrency;

    @Enumerated(EnumType.STRING)
    private Currency targetCurrency;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Timestamp timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}