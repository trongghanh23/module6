package com.example.be_fashion.service.customer.impl;

import com.example.be_fashion.model.customer.CustomerType;
import com.example.be_fashion.repository.customer.CustomerTypeRepository;
import com.example.be_fashion.service.customer.ICustomerTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findCustomerType() {
        return customerTypeRepository.findAll();
    }
}
