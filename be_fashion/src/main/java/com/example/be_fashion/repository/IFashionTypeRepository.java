package com.example.be_fashion.repository;

import com.example.be_fashion.model.fashion.FashionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFashionTypeRepository extends JpaRepository<FashionType,Integer> {
}
