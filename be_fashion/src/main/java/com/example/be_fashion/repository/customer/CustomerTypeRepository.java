package com.example.be_fashion.repository.customer;

import com.example.be_fashion.model.customer.CustomerType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
