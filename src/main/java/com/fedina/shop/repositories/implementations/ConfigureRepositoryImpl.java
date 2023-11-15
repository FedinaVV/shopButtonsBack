package com.fedina.shop.repositories.implementations;

import com.fedina.shop.entity.ConfigureEntity;
import com.fedina.shop.repositories.jpa.ConfigureJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfigureRepositoryImpl {

    private final ConfigureJpaRepository configureJpaRepository;

    @Autowired
    public ConfigureRepositoryImpl(ConfigureJpaRepository configureJpaRepository) {
        this.configureJpaRepository = configureJpaRepository;
    }

    /**
     * Возвращает список подробной информации о пуговицы
     */
    public List<ConfigureEntity> getAllConfigs() {
        return configureJpaRepository.getAllConfigs();
    }

    /**
     * Возвращает подробную информацию одной пуговицы
     * @param id - id подробной информации одной пуговицы
     */
    public ConfigureEntity getConfigById(Integer id) {
        return configureJpaRepository.getConfigById(id);
    }

    /**
     * Создает новую информацию одной пуговицы
     * @param configureEntity - сущность подробной информации
     */
    public void createNewConfigure(ConfigureEntity configureEntity) {
        configureJpaRepository.save(configureEntity);
    }

    /**
     * Обновляет подробную информацию одной пуговицы
     * @param configureEntity- сущность подробной информации
     */
    public void updateConfigure(ConfigureEntity configureEntity) {
       configureJpaRepository.save(configureEntity);
    }

    /**
     * Удаляет подробную информацию одной пуговицы
     * @param id - - id подробной информации одной пуговицы
     */
    public void deleteById(int id) {
        configureJpaRepository.deleteById(id);
    }
}
