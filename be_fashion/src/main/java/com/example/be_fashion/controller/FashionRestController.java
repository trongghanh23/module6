package com.example.be_fashion.controller;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.jwt.JwtTokenUtil;
import com.example.be_fashion.model.customer.Customer;
import com.example.be_fashion.service.customer.ICustomerService;
import com.example.be_fashion.service.fashion.IFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/fashion")
public class FashionRestController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFashionService iFashionService;



    @GetMapping("/list/home")
    public ResponseEntity<Page<IListFashionDto>> getList(@RequestParam (value = "name",defaultValue = "") String name,
                                                         @PageableDefault Pageable pageable){
        Page<IListFashionDto> iListFashion=iFashionService.listFashion(pageable,name);
        if (iListFashion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iListFashion,HttpStatus.OK);
    }
    @GetMapping("/get/customer")
    public ResponseEntity<Customer> getCustomerByUsername(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        String username = jwtTokenUtil.getUsernameFromJwtToken(headerAuth.substring(7));
        System.out.println(username);
        Customer customer = iCustomerService.findCustomerByUsername(username);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
