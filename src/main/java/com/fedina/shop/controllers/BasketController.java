package com.fedina.shop.controllers;

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
    public List<ButtonWithConfigure> getButtonsFromBasket() {
        List<ButtonWithConfigure> buttonWithConfigureList = new ArrayList<>();
        List<BasketEntity> basketEntityList = basketService.getBaskets();

        for (BasketEntity item : basketEntityList) {
            ButtonEntity buttonEntity = buttonsRepository.getButtonById(item.getButtonId());
            ConfigureEntity configureEntity = configureRepository.getConfigById(item.getConfigeId());

            ButtonWithConfigure buttonWithConfigure = new ButtonWithConfigure();
            buttonWithConfigure.setId(buttonEntity.getId());
            buttonWithConfigure.setTitle(buttonEntity.getTitle());
            buttonWithConfigure.setPrice(buttonEntity.getPrice());
            buttonWithConfigure.setImage(buttonEntity.getImage());
            buttonWithConfigure.setConfigure(configureEntity);

            buttonWithConfigureList.add(buttonWithConfigure);
        }
        return buttonWithConfigureList;
    }
}
