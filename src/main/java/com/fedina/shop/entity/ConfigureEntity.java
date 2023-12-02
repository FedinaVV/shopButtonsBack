package com.fedina.shop.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
@Entity
@Table(name = "configures")
public class ConfigureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer diameter;
    private String color;
    private Integer height;
    private Integer code;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    public ConfigureEntity() {

    }

    public ConfigureEntity(Integer id, Integer diameter, String color, Integer height, Integer code) {
        this.id = id;
        this.diameter = diameter;
        this.color = color;
        this.height = height;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
