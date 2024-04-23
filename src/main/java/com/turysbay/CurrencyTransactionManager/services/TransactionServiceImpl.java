package com.turysbay.CurrencyTransactionManager.services;

import com.turysbay.CurrencyTransactionManager.entity.ExchangeRate;
import com.turysbay.CurrencyTransactionManager.entity.Transaction;
import com.turysbay.CurrencyTransactionManager.entity.User;
import com.turysbay.CurrencyTransactionManager.exceptions.UserNotFoundException;
import com.turysbay.CurrencyTransactionManager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turysbay.CurrencyTransactionManager.repositories.TransactionRepository;
import com.turysbay.CurrencyTransactionManager.services.interfaces.TransactionService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final ExchangeRateServiceImpl exchangeRateService;
    private final SpendingLimitServiceImpl spendingLimitService;

    @Override
    public String makeTransaction(Long userId, Transaction transactionRequest) {

        Optional<User> optionalUser = userRepository.findById(userId);

        ExchangeRate exchangeRate = exchangeRateService.saveChangeRates(
                transactionRequest.getBaseCurrency().toString(),
                transactionRequest.getTargetCurrency().toString(),
                "1day",
                "1");

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            transactionRequest.setUser(user);
            transactionRequest.setTargetAmount(
                    BigDecimal.valueOf(exchangeRate.getClose())
                    .multiply(transactionRequest.getBaseAmount()));
            transactionRequest.setExchangeRate(exchangeRate.getClose());
            transactionRequest.setTimeStamp(new Timestamp(System.currentTimeMillis()));
            transactionRepository.save(transactionRequest);
            spendingLimitService.updateSpendingLimit(user,transactionRequest);
            return "Transaction successfully saved";
        } else {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

    }

    @Override
    public List<Transaction> getTransactionsExceedingLimit() {
        return transactionRepository.findAll();
    }
}
