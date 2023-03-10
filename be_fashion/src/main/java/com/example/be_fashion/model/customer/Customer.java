package com.example.be_fashion.model.customer;

import com.example.be_fashion.model.decentralization.User;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "boolean default 0")
    private boolean isDelete;
    private String name;
    private String dayOfBirth;
    private Integer gender;
    private String idCard;
    private String email;
    @Column(columnDefinition = "text")
    private String address;
    private String phoneNumber;

    @JoinColumn(name = "idCustomerType",referencedColumnName = "id")
    @ManyToOne
    private CustomerType customerType;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Customer() {
    }

    public Customer(Integer id, boolean isDelete, String name, String dayOfBirth, Integer gender, String idCard, String email, String address, String phoneNumber, CustomerType customerType, User user) {
        this.id = id;
        this.isDelete = isDelete;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
