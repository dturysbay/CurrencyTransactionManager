package com.turysbay.CurrencyTransactionManager.repositories;

import com.turysbay.CurrencyTransactionManager.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
}
