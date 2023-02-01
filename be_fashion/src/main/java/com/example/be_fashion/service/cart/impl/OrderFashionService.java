package com.example.be_fashion.service.cart.impl;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.repository.IOrderFashionRepository;
import com.example.be_fashion.service.cart.IOrderFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFashionService implements IOrderFashionService {
    @Autowired
    private IOrderFashionRepository iOrderFashionRepository;
    @Override
    public List<IListFashionDto> orderFashion(Integer id) {
        return iOrderFashionRepository.orderFashion(id);
    }
}
