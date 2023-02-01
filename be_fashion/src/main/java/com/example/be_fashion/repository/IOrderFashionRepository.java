package com.example.be_fashion.repository;

import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.OrderFashion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IOrderFashionRepository extends JpaRepository<OrderFashion,Integer> {
    @Query(value = "select order_fashion.id as idOrder, order_fashion.quantity as quantity,order_fashion.time_booking_fashion as timeBookingSmartphone,  " +
            "customer.id as idCustomer,customer.name as nameCustomer,customer.email as email,customer.address as address,customer.phone_number as phoneNumber, " +
            "fashion.id as idFashion,fashion.image as image,fashion.name as nameSeasonal,fashion.price as price " +
            "from order_fashion " +
            "join customer on order_fashion.customer_id=customer.id " +
            "join fashion on order_fashion.fashion_id=fashion.id " +
            "where order_fashion.quantity >0 " +
            "and order_fashion.is_delete=0 " +
            "and order_fashion.status=0 " +
            "and order_fashion.customer_id = :id",nativeQuery = true)
    List<IListFashionDto>orderFashion(@Param("id")Integer id);

}
