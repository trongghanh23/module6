package com.example.be_fashion.repository;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.Fashion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFashionRepository extends JpaRepository<Fashion, Integer> {
    @Query(value = "select fashion.id as idFashion ,fashion.material as material,fashion.name as nameFashion,fashion.producer as producer,fashion.image as image, fashion.price as price, " +
            "fashion_type.id as idFashionType,fashion_type.name as nameFashionType, " +
            "seasonal_fashion.id as idSeasonal,seasonal_fashion.name as nameSeasonal, " +
            "size.id as idSize,size.name as nameSize " +
            "from fashion " +
            "join fashion_type on fashion.id_fashion_type=fashion_type.id " +
            "join seasonal_fashion on fashion.id_seasonal_fashion=seasonal_fashion.id " +
            "join size on fashion.id_size=size.id " +
            "where fashion.name like %:keyword% ",
            countQuery = "select count(*)" +
                    "from fashion " +
                    "join fashion_type on fashion.id_fashion_type=fashion_type.id " +
                    "join seasonal_fashion on fashion.id_seasonal_fashion=seasonal_fashion.id " +
                    "join size on fashion.id_size=size.id " +
                    "where fashion.name like %:keyword% ", nativeQuery = true)
    Page<IListFashionDto> listFashion(Pageable pageable, @Param("keyword") String name);
}
//    and fashion.fashion_type.id= :id