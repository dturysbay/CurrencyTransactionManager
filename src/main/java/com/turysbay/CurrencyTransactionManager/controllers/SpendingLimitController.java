package com.turysbay.CurrencyTransactionManager.controllers;

import com.turysbay.CurrencyTransactionManager.entity.SpendingLimit;
import com.turysbay.CurrencyTransactionManager.services.SpendingLimitServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limits")
@AllArgsConstructor
public class SpendingLimitController {
    private final SpendingLimitServiceImpl spendingLimitService;

    @PostMapping("/update")
    private ResponseEntity<Void> updateLimit(@RequestBody SpendingLimit newSpendingLimit){
        SpendingLimit newLimit = spendingLimitService.setSpendingLimit(newSpendingLimit);
        if(newLimit != null){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<SpendingLimit>> getLimitsById(@PathVariable Long id){
        return new ResponseEntity<>(spendingLimitService.getAllSpendingLimits(id), HttpStatus.OK);
    }
}
