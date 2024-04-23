package com.turysbay.CurrencyTransactionManager.services.interfaces;

import com.turysbay.CurrencyTransactionManager.entity.Transaction;

import java.util.List;

public interface TransactionService {
    String makeTransaction(Long id,Transaction transaction);
    List<Transaction> getTransactionsExceedingLimit();
}
