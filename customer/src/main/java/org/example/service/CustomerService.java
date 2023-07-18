package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Customer;
import org.example.model.CustomerRegistrationRequest;
import org.example.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final ICustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        customerRepository.save(customer);
    }
}
