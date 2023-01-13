package com.example.be_fashion.service.fashion.impl;

import com.example.be_fashion.model.fashion.FashionType;
import com.example.be_fashion.repository.IFashionTypeRepository;
import com.example.be_fashion.service.fashion.IFashionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FashionTypeService implements IFashionTypeService {
    @Autowired
    private IFashionTypeRepository iFashionTypeRepository;

    @Override
    public List<FashionType> findAll() {
        return iFashionTypeRepository.findAll();
    }
}
