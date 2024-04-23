package com.turysbay.CurrencyTransactionManager.exceptions;

public class SpendingLimitNotFoundException extends RuntimeException {
    public SpendingLimitNotFoundException(String message) {
        super(message);
    }
}