package com.turysbay.CurrencyTransactionManager.services;

import com.turysbay.CurrencyTransactionManager.entity.SpendingLimit;
import com.turysbay.CurrencyTransactionManager.entity.Transaction;
import com.turysbay.CurrencyTransactionManager.entity.User;
import com.turysbay.CurrencyTransactionManager.enums.*;
import com.turysbay.CurrencyTransactionManager.services.interfaces.SpendingLimitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turysbay.CurrencyTransactionManager.repositories.SpendingLimitRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SpendingLimitServiceImpl implements SpendingLimitService {
    private final SpendingLimitRepository spendingLimitRepository;
    @Override
    public SpendingLimit setSpendingLimit(SpendingLimit newSpendingLimit) {
        newSpendingLimit.setLimitSetDate(new Date());
        newSpendingLimit.setLimitExceeded(false);
        newSpendingLimit.setAvailableMonthlyLimit(newSpendingLimit.getLimitAmount());
        return spendingLimitRepository.save(newSpendingLimit);
    }

    public List<SpendingLimit> getAllSpendingLimits() {
        return spendingLimitRepository.findAll();
    }

    public void initializeSpendingLimitsForUser(User user) {
        SpendingLimit goodsLimit = new SpendingLimit();
        goodsLimit.setUser(user);
        goodsLimit.setLimitAmount(BigDecimal.valueOf(1000));
        goodsLimit.setAvailableMonthlyLimit(BigDecimal.valueOf(1000));
        goodsLimit.setLimitExceeded(false);
        goodsLimit.setLimitCurrency(Currency.USD);
        goodsLimit.setCategory(Category.GOODS);
        goodsLimit.setLimitSetDate(new Date());

        SpendingLimit servicesLimit = new SpendingLimit();
        servicesLimit.setUser(user);
        servicesLimit.setLimitAmount(BigDecimal.valueOf(1000));
        servicesLimit.setAvailableMonthlyLimit(BigDecimal.valueOf(1000));
        servicesLimit.setLimitExceeded(false);
        servicesLimit.setLimitCurrency(Currency.USD);
        servicesLimit.setCategory(Category.SERVICES);
        servicesLimit.setLimitSetDate(new Date());

        spendingLimitRepository.save(goodsLimit);
        spendingLimitRepository.save(servicesLimit);
    }

    public void updateSpendingLimit(User user,Transaction transaction){

        List<SpendingLimit> existingLimit = spendingLimitRepository.findByUserIdAndCategoryAndLimitCurrency(
                user.getId(), transaction.getCategory(), transaction.getBaseCurrency());
        SpendingLimit updatedLimit = new SpendingLimit();
        for (SpendingLimit limit : existingLimit) {
                updatedLimit.setUser(limit.getUser());
                updatedLimit.setLimitSetDate(limit.getLimitSetDate());
                updatedLimit.setLimitAmount(limit.getLimitAmount());
                updatedLimit.setLimitCurrency(limit.getLimitCurrency());
                updatedLimit.setCategory(limit.getCategory());
                updatedLimit.setTransactionAmount(transaction.getBaseAmount());
                updatedLimit.setAvailableMonthlyLimit(limit.getAvailableMonthlyLimit().subtract(transaction.getBaseAmount()));
                updatedLimit.setLimitExceeded(updatedLimit.getAvailableMonthlyLimit().compareTo(BigDecimal.valueOf(0)) == -1);
        }
        spendingLimitRepository.save(updatedLimit);
    }
}
