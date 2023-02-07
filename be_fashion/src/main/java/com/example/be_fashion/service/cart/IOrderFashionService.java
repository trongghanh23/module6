package com.example.be_fashion.service.cart;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IHistoryDto;
import com.example.be_fashion.dto.IListFashionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrderFashionService {
    List<IListFashionDto>orderFashion(Integer id);

    Optional<IBookingDto> getCartCount(Integer id);
    void ascQuantity(Integer id);

    void descQuantity( Integer id);
    void addFashion(Integer quantity, Integer customerId,Integer fashionId);
    void payBookingFashion( Integer id);
    void deleteCart(Integer id);
    Page<IHistoryDto> getAllHistory(String username, Pageable pageable);
}
