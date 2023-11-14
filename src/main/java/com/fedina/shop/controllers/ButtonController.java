package com.fedina.shop.controllers;

import com.fedina.shop.dto.ButtonWithConfigure;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.ButtonsJpaRepositoryImpl;
import com.fedina.shop.repositories.implementations.ConfigureJpaRepositoryImpl;
import com.fedina.shop.repositories.jpa.ConfigureJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/buttons")
public class ButtonController {

    private final ConfigureJpaRepositoryImpl configureJpaRepository;
    private final ButtonsJpaRepositoryImpl buttonsJpaRepository;

    @Autowired
    public ButtonController(ConfigureJpaRepositoryImpl configureJpaRepository, ButtonsJpaRepositoryImpl buttonsJpaRepository) {
        this.configureJpaRepository = configureJpaRepository;
        this.buttonsJpaRepository = buttonsJpaRepository;
    }

    @GetMapping
    public List<ButtonWithConfigure> getButtons() {
        List<ButtonEntity> buttons = buttonsJpaRepository.list();
        List<ConfigureEntity> configures = configureJpaRepository.getAllConfigs();
        List<ButtonWithConfigure> btnsWithConfigs = new ArrayList<>();

        for (ButtonEntity button : buttons) {
            ButtonWithConfigure buttonWithConfigure = new ButtonWithConfigure();
            buttonWithConfigure.setId(button.getId());
            buttonWithConfigure.setTitle(button.getTitle());
            buttonWithConfigure.setPrice(button.getPrice());
            buttonWithConfigure.setImage(button.getImage());
            ConfigureEntity configure = configureJpaRepository.getConfigById(button.getConfigureId());
            buttonWithConfigure.setConfigure(configure);
            btnsWithConfigs.add(buttonWithConfigure);
        }

        return btnsWithConfigs;
    }

    @GetMapping("/get_by_id")
    public ButtonWithConfigure getById(@RequestParam(name = "id") int id) {
        ButtonEntity button = buttonsJpaRepository.getButtonById(id);
        ConfigureEntity configure = configureJpaRepository.getConfigById(button.getConfigureId());
        ButtonWithConfigure btnWithConfigure = new ButtonWithConfigure(id, button.getTitle(), button.getPrice(), button.getImage(), configure);

        return btnWithConfigure;
    }

    @PostMapping
    public ButtonWithConfigure postButtonWithConfigure(@RequestBody ButtonWithConfigure buttonWithConfigure) {
        ConfigureEntity configureEntity = buttonWithConfigure.getConfigure();
        configureJpaRepository.createNewConfigure(configureEntity);
        ButtonEntity buttonEntity = new ButtonEntity(null, buttonWithConfigure.getTitle(), buttonWithConfigure.getPrice(), buttonWithConfigure.getImage(), configureEntity.getId());
       buttonsJpaRepository.createNewButton(buttonEntity);
       buttonWithConfigure.setId(buttonEntity.getId());
        return buttonWithConfigure;
    }

    @DeleteMapping
    public void deleteButton(@RequestParam(name = "id") int id) {
        ButtonEntity buttonEntity = buttonsJpaRepository.getButtonById(id);
        buttonsJpaRepository.deleteById(id);
        configureJpaRepository.deleteById(buttonEntity.getConfigureId());
    }

    @PutMapping
    public ButtonWithConfigure updateButtonWithConfigure(@RequestBody ButtonWithConfigure buttonWithConfigure) {
        ButtonEntity buttonEntity = new ButtonEntity();
        buttonEntity.setId(buttonWithConfigure.getId());
        buttonEntity.setTitle(buttonWithConfigure.getTitle());
        buttonEntity.setPrice(buttonWithConfigure.getPrice());
        buttonEntity.setImage(buttonWithConfigure.getImage());
        buttonEntity.setConfigureId(buttonWithConfigure.getConfigure().getId());

        buttonsJpaRepository.updateButton(buttonEntity);
        configureJpaRepository.updateConfigure(buttonWithConfigure.getConfigure());

        return buttonWithConfigure;
    }



}


