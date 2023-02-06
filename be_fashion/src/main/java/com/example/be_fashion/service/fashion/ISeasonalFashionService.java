package com.example.be_fashion.service.fashion;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.SeasonalFashion;

import java.util.List;
import java.util.Optional;

public interface ISeasonalFashionService {
    List<SeasonalFashion>findAll();

}
