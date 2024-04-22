package com.turysbay.CurrencyTransactionManager.entity;

import com.turysbay.CurrencyTransactionManager.enums.Category;
import com.turysbay.CurrencyTransactionManager.enums.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpendingLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date limitSetDate;

    private Long limitUSD;
    private Long availableMonthlyLimitUSD;
    private Boolean limitExceeded;
}
