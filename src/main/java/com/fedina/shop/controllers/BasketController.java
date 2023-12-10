package com.fedina.shop.controllers;

import com.fedina.shop.dto.ButtonWithBasket;
import com.fedina.shop.dto.ButtonWithConfigure;
import com.fedina.shop.entity.BasketEntity;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.ButtonsRepositoryImpl;
import com.fedina.shop.repositories.implementations.ConfigureRepositoryImpl;
import com.fedina.shop.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;
    private final ButtonsRepositoryImpl buttonsRepository;
    private final ConfigureRepositoryImpl configureRepository;

    @Autowired
    public BasketController(BasketService basketService, ButtonsRepositoryImpl buttonsRepository, ConfigureRepositoryImpl configureRepository) {
        this.basketService = basketService;
        this.buttonsRepository = buttonsRepository;
        this.configureRepository = configureRepository;
    }

    @PostMapping
    public BasketEntity createButtonInBasket(@RequestBody ButtonWithConfigure buttonWithConfigure) {
        BasketEntity basketEntity = basketService.createButtonInBasket(buttonWithConfigure.getId(), buttonWithConfigure.getConfigure().getId(), null);
        return  basketEntity;
    }

    @GetMapping
    public List<ButtonWithBasket> getButtonsFromBasket() {
        List<ButtonWithBasket> buttonWithBasketList = new ArrayList<>();
        List<BasketEntity> basketEntityList = basketService.getBaskets();

        for (BasketEntity item : basketEntityList) {
            ButtonEntity buttonEntity = buttonsRepository.getButtonById(item.getButtonId());
            ConfigureEntity configureEntity = configureRepository.getConfigById(item.getConfigeId());
            ButtonWithBasket buttonWithBasket = new ButtonWithBasket();

            buttonWithBasket.setBasketId(item.getId());
            buttonWithBasket.setId(buttonEntity.getId());
            buttonWithBasket.setTitle(buttonEntity.getTitle());
            buttonWithBasket.setPrice(buttonEntity.getPrice());
            buttonWithBasket.setImage(buttonEntity.getImage());
            buttonWithBasket.setConfigure(configureEntity);

            buttonWithBasketList.add(buttonWithBasket);
        }

        return buttonWithBasketList;
    }

    @DeleteMapping
    public void deleteButtonFromBasket(@RequestParam(name = "id") int id) {
        basketService.deleteByIdFromBasket(id);
    }
}
