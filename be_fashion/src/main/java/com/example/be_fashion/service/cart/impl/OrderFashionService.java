package com.example.be_fashion.service.cart.impl;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.repository.IOrderFashionRepository;
import com.example.be_fashion.service.cart.IOrderFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderFashionService implements IOrderFashionService {
    @Autowired
    private IOrderFashionRepository iOrderFashionRepository;
    @Override
    public List<IListFashionDto> orderFashion(Integer id) {
        return iOrderFashionRepository.orderFashion(id);
    }
    @Override
    public Optional<IBookingDto> getCartCount(Integer id) {
        return iOrderFashionRepository.getCartCount(id);
    }
    @Override
    public void ascQuantity(Integer id) {
        iOrderFashionRepository.ascQuantity(id);
    }

    @Override
    public void descQuantity(Integer id) {
        iOrderFashionRepository.descQuantity(id);

    }
}
