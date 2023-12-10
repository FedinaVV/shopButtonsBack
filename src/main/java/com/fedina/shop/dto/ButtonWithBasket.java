package com.fedina.shop.dto;

import com.fedina.shop.entity.ConfigureEntity;

public class ButtonWithBasket extends ButtonWithConfigure{
    private Integer basketId;

    public ButtonWithBasket(){}

    public ButtonWithBasket(Integer basketId) {
        this.basketId = basketId;
    }

    public ButtonWithBasket(int id, String title, int price, String image, ConfigureEntity configure, Integer basketId) {
        super(id, title, price, image, configure);
        this.basketId = basketId;
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {
        this.basketId = basketId;
    }

}
