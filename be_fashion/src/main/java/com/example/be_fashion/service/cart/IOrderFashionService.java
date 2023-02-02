package com.example.be_fashion.service.cart;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IListFashionDto;

import java.util.List;
import java.util.Optional;

public interface IOrderFashionService {
    List<IListFashionDto>orderFashion(Integer id);

    Optional<IBookingDto> getCartCount(Integer id);
    void ascQuantity(Integer id);

    void descQuantity( Integer id);
}
