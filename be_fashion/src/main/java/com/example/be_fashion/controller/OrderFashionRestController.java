package com.example.be_fashion.controller;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.OrderFashion;
import com.example.be_fashion.service.cart.IOrderFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/booking")
public class OrderFashionRestController {
    @Autowired
    private IOrderFashionService iOrderFashionService;

    @GetMapping("list/cart/{id}")
    public ResponseEntity<List<IListFashionDto>> showCartByUser(@PathVariable("id") Integer id) {
        List<IListFashionDto> cart = iOrderFashionService.orderFashion(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart/count/{id}")
    public ResponseEntity<?> cartCount(@PathVariable("id") Integer id) {
        Optional<IBookingDto> getCarCount = iOrderFashionService.getCartCount(id);

        if (getCarCount.isPresent()) {
            return new ResponseEntity<>(getCarCount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/asc/quantity/{id}")
    public ResponseEntity<OrderFashion> ascQuantity(@PathVariable("id") Integer id) {
        iOrderFashionService.ascQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/desc/quantity/{id}")
    public ResponseEntity<OrderFashion> descQuantity(@PathVariable("id") Integer id) {
        iOrderFashionService.descQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/add/cart/{quantity}&{customerId}&{fashionId}")
    public ResponseEntity<OrderFashion> addCart(@PathVariable("quantity") Integer quantity,
                                                @PathVariable("customerId") Integer customerId,
                                                @PathVariable("fashionId")Integer fashionId){
        iOrderFashionService.addFashion(quantity, customerId, fashionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/pay/fashion/{id}")
    public ResponseEntity<OrderFashion> payBookingFashion(@PathVariable("id") Integer id) {
        iOrderFashionService.payBookingFashion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
