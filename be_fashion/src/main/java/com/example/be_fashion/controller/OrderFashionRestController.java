package com.example.be_fashion.controller;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.service.cart.IOrderFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
