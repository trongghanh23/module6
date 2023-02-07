package com.example.be_fashion.repository;

import com.example.be_fashion.dto.IBookingDto;
import com.example.be_fashion.dto.IHistoryDto;
import com.example.be_fashion.dto.IListFashionDto;
import com.example.be_fashion.model.fashion.OrderFashion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Query(value = "select count(id) as cartCount " +
            "from order_fashion " +
            "where order_fashion.customer_id= :id " +
            "and  order_fashion.is_delete = 0  " +
            "and order_fashion.status = 0 ",nativeQuery = true)
    Optional<IBookingDto> getCartCount(@Param("id") Integer id);

    @Modifying
    @Query(value = "update order_fashion set quantity = (quantity + 1) where id = :id and status = 0", nativeQuery = true)
    void ascQuantity(@Param("id") Integer id);

    @Modifying
    @Query(value = "update order_fashion set quantity = (quantity - 1) where id = :id and status = 0", nativeQuery = true)
    void descQuantity(@Param("id") Integer id);

    @Query(value = "select * from order_fashion where status = 0 and is_delete = 0 and customer_id = :customerId " +
            "and fashion_id = :fashionId", nativeQuery = true)
    Optional<OrderFashion> getBookingFashionCart(@Param("customerId") Integer customerId,
                                                      @Param("fashionId") Integer fashionId);

    @Modifying
    @Query(value = "insert into order_fashion (time_booking_fashion , quantity, customer_id,fashion_id) " +
            "value (now(),:quantity,:customerId,:fashionId) ", nativeQuery = true)
    void addFashion(@Param("quantity") Integer quantity,
                       @Param("customerId") Integer customerId,
                       @Param("fashionId") Integer fashionId);
        @Modifying
        @Query(value = "update order_fashion set quantity = :quantity where status = 0 and customer_id = :customerId " +
                "and fashion_id = :fashionId", nativeQuery = true)
        void setQuantityFashion(@Param("quantity") Integer quantity,
                                   @Param("customerId") Integer customerId,
                                   @Param("fashionId") Integer fashionId);
    @Modifying
    @Query(value = "update order_fashion set order_fashion.status = 1 where order_fashion.customer_id = :id " +
            "and is_delete = 0 and order_fashion.status = 0 ", nativeQuery = true)
    void payBookingFashion(@Param("id") Integer id);

    @Modifying
    @Query(value = "update order_fashion set is_delete = 1 where id = :id ", nativeQuery = true)
    void deleteCart(@Param("id") Integer id);


    @Query(value = "select order_fashion.time_booking_fashion as timeBookingFashion ,order_fashion.quantity as quantity,fashion.name as nameFashion ,fashion.price as price  , " +
            "(order_fashion.quantity * fashion.price) as total " +
            "from order_fashion " +
            "join customer " +
            "on order_fashion.customer_id=customer.id " +
            "join fashion " +
            "on order_fashion.fashion_id= fashion.id " +
            "where  customer.username = username and order_fashion.status=1 and order_fashion.is_delete = 0 " +
            "order by order_fashion.time_booking_fashion desc ",
            countQuery = "select count(*) from order_fashion " +
            "join customer " +
            "on order_fashion.customer_id=customer.id " +
            "join fashion " +
            "on order_fashion.fashion_id= fashion.id " +
            "where  customer.username = username and order_fashion.status=1 and order_fashion.is_delete = 0 " +
            "order by order_fashion.time_booking_fashion desc ",nativeQuery = true)
    Page<IHistoryDto> getAllHistory(@Param("username") String username, Pageable pageable);

}
