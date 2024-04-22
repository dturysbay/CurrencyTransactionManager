package com.turysbay.CurrencyTransactionManager.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turysbay.CurrencyTransactionManager.entity.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.turysbay.CurrencyTransactionManager.repositories.ExchangeRateRepository;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl {
    private final ExchangeRateRepository exchangeRateRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.twelvedata.com/time_series";
    private static final String API_KEY = "b89da7f38a71448abdeb91ef2d4f05a3";

    public ExchangeRate saveChangeRates(String baseCurrency,String targetCurrency,String interval, String outputsize) {

        String apiUrl = String.format("%s?symbol=%s/%s&interval=%s&outputsize=%s&apikey=%s&source=docs",
                API_URL,baseCurrency, targetCurrency, interval, outputsize, API_KEY);
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        System.out.println(jsonResponse);
        ExchangeRate exchangeRate = new ExchangeRate();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode valuesNode = jsonNode.get("values");

            if(valuesNode!=null && valuesNode.isArray() && valuesNode.size() > 0){
                JsonNode firstValueNode = valuesNode.get(0);
                exchangeRate.setDatetime(firstValueNode.get("datetime").asText());

                if(firstValueNode.has("close")){
                    exchangeRate.setClose(firstValueNode.get("close").asDouble());
                }else{
                    exchangeRate.setClose(firstValueNode.get("previous_close").asDouble());
                }

                exchangeRate.setBaseCurrency(baseCurrency);
                exchangeRate.setTargetCurrency(targetCurrency);
                exchangeRateRepository.save(exchangeRate);
            }

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return exchangeRate;
    }
}

