package com.fedina.shop.services;

import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.implementations.ConfigureRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigureService {

    private final ConfigureRepositoryImpl configureRepository;

    @Autowired
    public ConfigureService(ConfigureRepositoryImpl configureRepository) {
        this.configureRepository = configureRepository;
    }

    /**
     * Возвращает список подробной информации о пуговицы
     */
    public List<ConfigureEntity> getAllConfigs() {
        return configureRepository.getAllConfigs();
    }

    /**
     * Возвращает подробную информацию одной пуговицы
     * @param id - id подробной информации одной пуговицы
     */
    public ConfigureEntity getConfigById(Integer id) {
        return configureRepository.getConfigById(id);
    }

    /**
     * Создает новую информацию одной пуговицы
     * @param configureEntity - сущность подробной информации
     */
    public void createNewConfigure(ConfigureEntity configureEntity) {
        configureRepository.createNewConfigure(configureEntity);
    }

    /**
     * Обновляет подробную информацию одной пуговицы
     * @param configureEntity- сущность подробной информации
     */
    public void updateConfigure(ConfigureEntity configureEntity) {
        configureRepository.updateConfigure(configureEntity);
    }

    /**
     * Удаляет подробную информацию одной пуговицы
     * @param id - - id подробной информации одной пуговицы
     */
    public void deleteById(int id) {
        configureRepository.deleteById(id);
    }
}
