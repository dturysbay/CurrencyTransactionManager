package com.turysbay.CurrencyTransactionManager.services;

import com.turysbay.CurrencyTransactionManager.entity.User;
import com.turysbay.CurrencyTransactionManager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final SpendingLimitServiceImpl spendingLimitService;

    public User createUser(User user){
        User savedUser = userRepository.save(user);
        spendingLimitService.initializeSpendingLimitsForUser(savedUser);
        return savedUser;
    }

}
