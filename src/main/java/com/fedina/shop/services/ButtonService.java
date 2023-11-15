package com.fedina.shop.services;

import com.fedina.shop.dto.ButtonWithConfigure;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.ButtonsRepositoryImpl;
import com.fedina.shop.repositories.implementations.ConfigureRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonService {

    private final ButtonsRepositoryImpl buttonsRepository;
    private final ConfigureRepositoryImpl configureRepository;

    @Autowired
    public ButtonService(ButtonsRepositoryImpl buttonsRepository, ConfigureRepositoryImpl configureRepository) {
        this.buttonsRepository = buttonsRepository;
        this.configureRepository = configureRepository;
    }

    /**
     * Возвращает список всех пуговиц
     */
    public List<ButtonEntity> list() {
        return buttonsRepository.list();
    }

    /**
     * Возвращает пуговицу по id
     * @param id - id пуговицы
     */
    public ButtonEntity getButtonById(int id) {
        return buttonsRepository.getButtonById(id);
    }

    /**
     * Создает новую пуговицу
     * @param button - сущность пуговицы
     */
    public void createNewButton(ButtonEntity button) {
        buttonsRepository.createNewButton(button);
    }

    /**
     * Обновляет пуговицу
     * @param button - сущность пуговицы
     */
    public void updateButton(ButtonEntity button) {
        buttonsRepository.updateButton(button);
    }

    /**
     * Удаляет пуговицу
     * @param id - id пуговицы
     */
    public void deleteById(int id) {
        buttonsRepository.deleteById(id);
    }

    public List<ButtonWithConfigure> getButtonsWithConfigure(){
        List<ButtonEntity> buttons = buttonsRepository.list();
        List<ButtonWithConfigure> btnsWithConfigs = new ArrayList<>();

        for (ButtonEntity button : buttons) {
            ButtonWithConfigure buttonWithConfigure = new ButtonWithConfigure();
            buttonWithConfigure.setId(button.getId());
            buttonWithConfigure.setTitle(button.getTitle());
            buttonWithConfigure.setPrice(button.getPrice());
            buttonWithConfigure.setImage(button.getImage());
            ConfigureEntity configure = configureRepository.getConfigById(button.getConfigureId());
            buttonWithConfigure.setConfigure(configure);
            btnsWithConfigs.add(buttonWithConfigure);
        }

        return btnsWithConfigs;
    }
}
