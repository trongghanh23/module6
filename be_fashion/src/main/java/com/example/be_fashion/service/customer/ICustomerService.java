package com.example.be_fashion.service.customer;

import com.example.be_fashion.model.customer.Customer;

import java.util.List;

public interface ICustomerService {

    Customer findCustomerByUsername(String username);

    List<Customer>findAll();
}
