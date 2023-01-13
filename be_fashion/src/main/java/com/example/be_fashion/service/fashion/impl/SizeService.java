package com.example.be_fashion.service.fashion.impl;

import com.example.be_fashion.model.fashion.Size;
import com.example.be_fashion.repository.ISizeRepository;
import com.example.be_fashion.service.fashion.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository iSizeRepository;

    @Override
    public List<Size> findAll() {
        return iSizeRepository.findAll();
    }
}
