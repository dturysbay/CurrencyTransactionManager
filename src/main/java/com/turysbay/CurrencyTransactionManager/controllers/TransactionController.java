package com.turysbay.CurrencyTransactionManager.controllers;

import com.turysbay.CurrencyTransactionManager.entity.Transaction;
import com.turysbay.CurrencyTransactionManager.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.turysbay.CurrencyTransactionManager.services.TransactionServiceImpl;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    @PostMapping("/{userId}/makeTransaction")
    public ResponseEntity<String> makeTransaction(@PathVariable Long userId,
                                                  @RequestBody Transaction transactionRequest) {
        try {
            String status = transactionService.makeTransaction(userId, transactionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Transaction made successfully!");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}