package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.FraudCheckResponse;
import org.example.service.FraudCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping(path = {"customerId"})
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId ){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Fraud check for customer with {}",customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}