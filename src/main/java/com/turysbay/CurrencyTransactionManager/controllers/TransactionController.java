package com.turysbay.CurrencyTransactionManager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.turysbay.CurrencyTransactionManager.services.TransactionServiceImpl;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

//    @PostMapping("/add")
//    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
//        Transaction savedTransaction = transactionService.saveTransaction(transaction);
//        return ResponseEntity.ok(savedTransaction);
//    }
//
//    @GetMapping("/exceeding-limit")
//    public ResponseEntity<List<Transaction>> getTransactionsExceedingLimit(){
//        List<Transaction> exceedingTransactions = transactionService.getTransactionsExceedingLimit();
//        return ResponseEntity.ok(exceedingTransactions);
//    }

}
