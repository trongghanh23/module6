package com.example.be_fashion.service.fashion;

import com.example.be_fashion.dto.IListFashionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFashionService {
     Page<IListFashionDto>listFashion(Pageable pageable, String keyword);


}
