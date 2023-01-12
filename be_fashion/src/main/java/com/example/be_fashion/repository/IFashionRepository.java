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
public interface IFashionRepository extends JpaRepository<Fashion,Integer> {
    @Query(value = "select fashion.id ,fashion.material,fashion.`name`,fashion.producer,fashion.image, " +
            "fashion_type.id,fashion_type.`name`, " +
            "seasonal_fashion.id,seasonal_fashion.`name`, " +
            "size.id,size.`name` " +
            "from fashion " +
            "join fashion_type on fashion.id_fashion_type=fashion_type.id " +
            "join seasonal_fashion on fashion.id_seasonal_fashion=seasonal_fashion.id " +
            "join size on fashion.id_size=size.id " +
            "where fashion.name like %:keyword% and fashion.fashion_type.id= :id ",
            countQuery = "select count(*)" +
                    "from fashion " +
                    "join fashion_type on fashion.id_fashion_type=fashion_type.id " +
                    "join seasonal_fashion on fashion.id_seasonal_fashion=seasonal_fashion.id " +
                    "join size on fashion.id_size=size.id " +
                    "where fashion.name like %:keyword% and fashion.fashion_type.id= :id", nativeQuery = true)
    Page<IListFashionDto>listFashion(Pageable pageable , @Param("keyword")String name);
}
