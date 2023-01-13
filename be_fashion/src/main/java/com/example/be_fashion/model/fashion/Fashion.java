package com.example.be_fashion.model.fashion;

import javax.persistence.*;

@Entity
public class Fashion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "text")
    private String image;
    private String producer;
    private String material;

    private int price;

    @JoinColumn(name = "idFashionType",referencedColumnName = "id")
    @ManyToOne
    private FashionType fashionType;

    @JoinColumn(name = "idSeasonalFashion",referencedColumnName = "id")
    @ManyToOne
    private SeasonalFashion seasonalFashion;

    @JoinColumn(name = "idSize",referencedColumnName = "id")
    @ManyToOne
    private Size size;

    @Column(columnDefinition = "boolean default 0")
    private boolean isDelete;

    public Fashion() {
    }


    public Fashion(Integer id, String name, String image, String producer, String material, int price, FashionType fashionType, SeasonalFashion seasonalFashion, Size size, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.producer = producer;
        this.material = material;
        this.price = price;
        this.fashionType = fashionType;
        this.seasonalFashion = seasonalFashion;
        this.size = size;
        this.isDelete = isDelete;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FashionType getFashionType() {
        return fashionType;
    }

    public void setFashionType(FashionType fashionType) {
        this.fashionType = fashionType;
    }

    public SeasonalFashion getSeasonalFashion() {
        return seasonalFashion;
    }

    public void setSeasonalFashion(SeasonalFashion seasonalFashion) {
        this.seasonalFashion = seasonalFashion;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
