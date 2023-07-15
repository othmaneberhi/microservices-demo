package org.example.service;

import org.example.model.Customer;
import org.example.model.CustomerRegistrationRequest;
import org.example.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(ICustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        customerRepository.save(customer);
    }
}
