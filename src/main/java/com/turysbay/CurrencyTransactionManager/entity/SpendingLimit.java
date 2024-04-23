package com.turysbay.CurrencyTransactionManager.entity;

import com.turysbay.CurrencyTransactionManager.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class SpendingLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date limitSetDate;

    private BigDecimal limitAmount;
    private BigDecimal availableMonthlyLimit;
    private BigDecimal transactionAmount;
    private Boolean limitExceeded;

    @Enumerated(EnumType.STRING)
    private Currency limitCurrency;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}