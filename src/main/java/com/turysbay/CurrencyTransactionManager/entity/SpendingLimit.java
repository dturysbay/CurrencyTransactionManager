package com.turysbay.CurrencyTransactionManager.entity;

import com.turysbay.CurrencyTransactionManager.enums.Category;
import com.turysbay.CurrencyTransactionManager.enums.Currency;
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

    private BigDecimal limitUSD;
    private BigDecimal availableMonthlyLimitUSD;
    private Boolean limitExceeded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}