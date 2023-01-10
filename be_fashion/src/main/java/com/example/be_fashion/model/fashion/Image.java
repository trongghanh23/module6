package com.example.be_fashion.model.fashion;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "boolean default 0")
    private boolean isDelete;
     @ManyToOne
    @JoinColumn(name = "fashionId",referencedColumnName = "id")
    private Fashion fashion;

    public Image() {
    }

    public Image(Integer id, String name, boolean isDelete, Fashion fashion) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.fashion = fashion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fashion getFashion() {
        return fashion;
    }

    public void setFashion(Fashion fashion) {
        this.fashion = fashion;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
