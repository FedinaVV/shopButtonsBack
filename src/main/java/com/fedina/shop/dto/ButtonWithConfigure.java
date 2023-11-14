package com.fedina.shop.dto;

import com.fedina.shop.entity.ConfigureEntity;

public class ButtonWithConfigure {
    private Integer id;
    private String title;
    private Integer price;
    private String image;
    private ConfigureEntity configure;

    public ButtonWithConfigure() {
    }

    public ButtonWithConfigure(int id, String title, int price, String image, ConfigureEntity configure) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.configure = configure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ConfigureEntity getConfigure() {
        return configure;
    }

    public void setConfigure(ConfigureEntity configure) {
        this.configure = configure;
    }
}


