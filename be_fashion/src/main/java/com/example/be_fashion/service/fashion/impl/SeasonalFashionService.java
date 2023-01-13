package com.example.be_fashion.service.fashion.impl;

import com.example.be_fashion.model.fashion.SeasonalFashion;
import com.example.be_fashion.repository.ISeasonalFashionRepository;
import com.example.be_fashion.service.fashion.ISeasonalFashionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeasonalFashionService implements ISeasonalFashionService {
    @Autowired
    private ISeasonalFashionRepository iSeasonalFashionRepository;

    @Override
    public List<SeasonalFashion> findAll() {
        return iSeasonalFashionRepository.findAll();
    }
}
