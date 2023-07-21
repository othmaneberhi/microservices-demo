package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clients.fraud.FraudCheckResponse;
import org.example.clients.fraud.FraudClient;
import org.example.model.Customer;
import org.example.model.CustomerRegistrationRequest;
import org.example.repository.ICustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final ICustomerRepository customerRepository;
    private final FraudClient fraudClient;
    @PostMapping
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("customer registration: {}",customerRegistrationRequest);
        Customer customer = Customer.builder()
                .email(customerRegistrationRequest.email())
                .firstname(customerRegistrationRequest.firstname())
                .lastname(customerRegistrationRequest.lastname())
                .build();
        //todo: check mail
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            return ResponseEntity.ok("Customer is a fraud!");
        } else {
            return ResponseEntity.ok("Customer is not a fraud!");
        }
    }
}