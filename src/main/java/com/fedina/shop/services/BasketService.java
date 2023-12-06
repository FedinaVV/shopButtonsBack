package com.fedina.shop.services;

import com.fedina.shop.dto.ButtonWithConfigure;
import com.fedina.shop.entity.BasketEntity;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.BasketRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private final BasketRepositoryImpl basketRepository;

    @Autowired
    public BasketService(BasketRepositoryImpl basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketEntity createButtonInBasket(Integer buttonId, Integer configeId, Integer userId) {

        // создание объекта Корзина через конструктор
        BasketEntity basketEntity = new BasketEntity(buttonId, configeId, userId);

        /* создание объекта Корзина через сеттеры
        BasketEntity basketEntity1 = new BasketEntity();
        basketEntity1.setButtonId(buttonId);
        basketEntity1.setConfigeId(configeId);
        basketEntity1.setUserId(userId);*/

        return basketRepository.createButtonInBasket(basketEntity);
    }

    public List<BasketEntity> getBaskets(){
        return basketRepository.getBaskets();
    }

    /**
     * Удаляет пуговицу
     * @param id - id пуговицы
     */
    public void deleteByIdFromBasket(int id) {
        basketRepository.deleteByIdFromBasket(id);
    }


}
