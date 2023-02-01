package com.example.be_fashion.service.customer.impl;

import com.example.be_fashion.model.customer.Customer;
import com.example.be_fashion.repository.customer.CustomerRepository;
import com.example.be_fashion.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
