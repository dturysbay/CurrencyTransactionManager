package com.turysbay.CurrencyTransactionManager.services;

import com.turysbay.CurrencyTransactionManager.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turysbay.CurrencyTransactionManager.repositories.TransactionRepository;
import com.turysbay.CurrencyTransactionManager.services.interfaces.TransactionService;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsExceedingLimit() {
        return transactionRepository.findAll();
    }
}
