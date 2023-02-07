package com.example.be_fashion.service.cart.impl;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IHistoryDto;
import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.OrderFashion;
import com.example.be_fashion.repository.IOrderFashionRepository;
import com.example.be_fashion.service.cart.IOrderFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void addFashion(Integer quantity, Integer customerId, Integer fashionId) {
        Optional<OrderFashion> bookingFashion = iOrderFashionRepository.getBookingFashionCart(customerId, fashionId);

        if (bookingFashion.isPresent()) {
            iOrderFashionRepository.setQuantityFashion(bookingFashion.get().getQuantity() + quantity, customerId, fashionId);
        } else {
            iOrderFashionRepository.addFashion(quantity, customerId, fashionId);
        }
    }

    @Override
    public void payBookingFashion(Integer id) {
        iOrderFashionRepository.payBookingFashion(id);

    }
    @Override
    public void deleteCart(Integer id) {
        iOrderFashionRepository.deleteCart(id);
    }

    @Override
    public Page<IHistoryDto> getAllHistory(String username, Pageable pageable) {
        return iOrderFashionRepository.getAllHistory(username, pageable);
    }

}




