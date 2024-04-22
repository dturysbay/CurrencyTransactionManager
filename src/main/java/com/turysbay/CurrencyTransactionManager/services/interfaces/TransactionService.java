package com.turysbay.CurrencyTransactionManager.services.interfaces;

import com.turysbay.CurrencyTransactionManager.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getTransactionsExceedingLimit();
}
