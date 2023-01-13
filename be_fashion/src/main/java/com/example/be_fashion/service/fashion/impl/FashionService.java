package com.example.be_fashion.service.fashion.impl;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.repository.IFashionRepository;
import com.example.be_fashion.service.fashion.IFashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FashionService implements IFashionService {
    @Autowired
    private IFashionRepository iFashionRepository;
    @Override
    public Page<IListFashionDto> listFashion(Pageable pageable, String name) {
        return iFashionRepository.listFashion(pageable, name);
    }
}
