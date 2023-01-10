package com.example.be_fashion.model.employee;

import com.example.be_fashion.model.decentralization.User;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean isDelete;
    private Integer gender;
    private String email;
    private String address;
    private String phone_number;
    private String idCard;
    private String dayOfBirth;
    private String image;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")

    private User user;

    public Employee() {
    }

    public Employee(Integer id, boolean isDelete, Integer gender, String email, String address, String phone_number, String idCard, String dayOfBirth, String image, User user) {
        this.id = id;
        this.isDelete = isDelete;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.idCard = idCard;
        this.dayOfBirth = dayOfBirth;
        this.image = image;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
