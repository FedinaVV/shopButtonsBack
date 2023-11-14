package com.fedina.shop.repositories.implementations;

import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.repositories.jpa.ButtonsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ButtonsJpaRepositoryImpl {
    ButtonsJpaRepository buttonsJpaRepository;

    @Autowired
    public ButtonsJpaRepositoryImpl(ButtonsJpaRepository buttonsJpaRepository) {
        this.buttonsJpaRepository = buttonsJpaRepository;
    }

    /**
     * Возвращает список всех пуговиц
     */
    public List<ButtonEntity> list() {
        return buttonsJpaRepository.list();
    }

    /**
     * Возвращает пуговицу по id
     * @param id - id пуговицы
     */
    public ButtonEntity getButtonById(int id) {
        return buttonsJpaRepository.getButtonById(id);
    }

    /**
     * Создает новую пуговицу
     * @param button - сущность пуговицы
     */
    public void createNewButton(ButtonEntity button) {
        buttonsJpaRepository.save(button);
    }

    /**
     * Обновляет пуговицу
     * @param button - сущность пуговицы
     */
    public void updateButton(ButtonEntity button) {
        buttonsJpaRepository.save(button);
    }

    /**
     * Удв=аляет пуговицу
     * @param id - id пуговицы
     */
    public void deleteById(int id) {
        buttonsJpaRepository.deleteById(id);
    }
}
