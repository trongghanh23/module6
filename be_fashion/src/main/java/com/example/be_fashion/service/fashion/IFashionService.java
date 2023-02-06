package com.example.be_fashion.service.fashion;

import com.example.be_fashion.dto.IListFashionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFashionService {
     Page<IListFashionDto>listFashion(Pageable pageable, String keyword);
     Optional<IListFashionDto> detailFashion(Integer id);

}
