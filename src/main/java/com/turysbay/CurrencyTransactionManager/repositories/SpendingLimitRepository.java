package com.turysbay.CurrencyTransactionManager.repositories;

import com.turysbay.CurrencyTransactionManager.entity.SpendingLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingLimitRepository extends JpaRepository<SpendingLimit,Long> {
}
