package com.fedina.shop.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "buttons")
public class ButtonEntity {

    //поля класса (для записи полей из таблицы БД в java)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "image")
    private String image;

    @Column(name = "confige_id")
    private int configureId;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    //конструкторы

    public ButtonEntity() {
    }

    public ButtonEntity(Integer id, String title, Integer price, String image, int configureId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.configureId = configureId;
    }

    //геттеры и сеттеры для полей

    public int getConfigureId() {
        return configureId;
    }
    public void setConfigureId(int configureID) {
        this.configureId = configureID;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}




