package com.turysbay.CurrencyTransactionManager.repositories;

import com.turysbay.CurrencyTransactionManager.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
