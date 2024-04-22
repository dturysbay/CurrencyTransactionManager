package com.turysbay.CurrencyTransactionManager.controllers;

import com.turysbay.CurrencyTransactionManager.entity.ExchangeRate;
import com.turysbay.CurrencyTransactionManager.services.ExchangeRateServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates")
@AllArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateServiceImpl exchangeRateService;

    @GetMapping
    public ResponseEntity<ExchangeRate> getRates(
            @RequestParam String baseCurrency,
            @RequestParam String targetCurrency,
            @RequestParam String interval,
            @RequestParam String outputsize
    ) {
        ExchangeRate exchangeRate = exchangeRateService
                .saveChangeRates(baseCurrency,targetCurrency,interval,outputsize);

        if(exchangeRate !=null){
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
