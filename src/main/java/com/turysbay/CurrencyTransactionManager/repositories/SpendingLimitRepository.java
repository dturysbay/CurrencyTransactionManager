package com.turysbay.CurrencyTransactionManager.repositories;

import com.turysbay.CurrencyTransactionManager.entity.SpendingLimit;
import com.turysbay.CurrencyTransactionManager.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingLimitRepository extends JpaRepository<SpendingLimit,Long> {
    List<SpendingLimit> findByUserId(Long userId);
    List<SpendingLimit> findByUserIdAndCategoryAndLimitCurrency(Long userId, Category category, Currency limitCurrency);
}
