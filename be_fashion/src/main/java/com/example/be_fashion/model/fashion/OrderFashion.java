package com.example.be_fashion.model.fashion;

import com.example.be_fashion.model.customer.Customer;

import javax.persistence.*;

@Entity
public class OrderFashion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String timeBookingFashion;
    @Column(columnDefinition = "boolean default 0")
    private boolean isDelete;
    private int quantity;
    private boolean status;


    @JoinColumn(name = "fashionId",referencedColumnName = "id")
    @ManyToOne
    private Fashion fashion;
     @JoinColumn(name = "customerId",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    public OrderFashion() {
    }

    public OrderFashion(Integer id, String timeBookingFashion, boolean isDelete, int quantity, boolean status, Fashion fashion, Customer customer) {
        this.id = id;
        this.timeBookingFashion = timeBookingFashion;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.status = status;
        this.fashion = fashion;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeBookingFashion() {
        return timeBookingFashion;
    }

    public void setTimeBookingFashion(String timeBookingFashion) {
        this.timeBookingFashion = timeBookingFashion;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Fashion getFashion() {
        return fashion;
    }

    public void setFashion(Fashion fashion) {
        this.fashion = fashion;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
