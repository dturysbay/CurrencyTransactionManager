package com.turysbay.CurrencyTransactionManager.services;

import com.turysbay.CurrencyTransactionManager.entity.SpendingLimit;
import com.turysbay.CurrencyTransactionManager.services.interfaces.SpendingLimitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.turysbay.CurrencyTransactionManager.repositories.SpendingLimitRepository;

@Service
@AllArgsConstructor
public class SpendingLimitServiceImpl implements SpendingLimitService {
    private final SpendingLimitRepository spendingLimitRepository;
    @Override
    public SpendingLimit setSpendingLimit(SpendingLimit spendingLimit) {
        return spendingLimitRepository.save(spendingLimit);
    }
}
