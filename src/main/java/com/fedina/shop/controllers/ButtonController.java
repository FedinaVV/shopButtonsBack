package com.fedina.shop.controllers;

import com.fedina.shop.dto.ButtonWithConfigure;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.ButtonsRepositoryImpl;
import com.fedina.shop.repositories.implementations.ConfigureRepositoryImpl;
import com.fedina.shop.services.ButtonService;
import com.fedina.shop.services.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/buttons")
public class ButtonController {

    private final ConfigureService configureService;
    private final ButtonService buttonsService;

    @Autowired
    public ButtonController(ConfigureService configureService, ButtonService buttonsService) {
        this.configureService = configureService;
        this.buttonsService = buttonsService;
    }

    @GetMapping
    public List<ButtonWithConfigure> getButtons() {
       return buttonsService.getButtonsWithConfigure();
    }

    @GetMapping("/get_by_id")
    public ButtonWithConfigure getById(@RequestParam(name = "id") int id) {
        ButtonEntity button = buttonsService.getButtonById(id);
        ConfigureEntity configure = configureService.getConfigById(button.getConfigureId());
        ButtonWithConfigure btnWithConfigure = new ButtonWithConfigure(id, button.getTitle(), button.getPrice(), button.getImage(), configure);

        return btnWithConfigure;
    }

    @PostMapping
    public ButtonWithConfigure postButtonWithConfigure(@RequestBody ButtonWithConfigure buttonWithConfigure) {
        ConfigureEntity configureEntity = buttonWithConfigure.getConfigure();
        configureService.createNewConfigure(configureEntity);
        ButtonEntity buttonEntity = new ButtonEntity(null, buttonWithConfigure.getTitle(), buttonWithConfigure.getPrice(), buttonWithConfigure.getImage(), configureEntity.getId());
       buttonsService.createNewButton(buttonEntity);
       buttonWithConfigure.setId(buttonEntity.getId());
        return buttonWithConfigure;
    }

    @DeleteMapping
    public void deleteButton(@RequestParam(name = "id") int id) {
        ButtonEntity buttonEntity = buttonsService.getButtonById(id);
        buttonsService.deleteById(id);
        configureService.deleteById(buttonEntity.getConfigureId());
    }

    @PutMapping
    public ButtonWithConfigure updateButtonWithConfigure(@RequestBody ButtonWithConfigure buttonWithConfigure) {
        ButtonEntity buttonEntity = new ButtonEntity();
        buttonEntity.setId(buttonWithConfigure.getId());
        buttonEntity.setTitle(buttonWithConfigure.getTitle());
        buttonEntity.setPrice(buttonWithConfigure.getPrice());
        buttonEntity.setImage(buttonWithConfigure.getImage());
        buttonEntity.setConfigureId(buttonWithConfigure.getConfigure().getId());

        buttonsService.updateButton(buttonEntity);
        configureService.updateConfigure(buttonWithConfigure.getConfigure());

        return buttonWithConfigure;
    }



}


