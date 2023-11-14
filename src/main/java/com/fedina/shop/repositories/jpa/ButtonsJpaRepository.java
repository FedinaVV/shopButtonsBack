package com.fedina.shop.repositories.jpa;

import com.fedina.shop.entity.ButtonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButtonsJpaRepository extends JpaRepository<ButtonEntity, Integer> {

    @Query(value = "SELECT * FROM buttons", nativeQuery = true)
    List<ButtonEntity> list();

    /**
     * Возвращает пуговицу по id (вариант 1 - через SQL-запрос в БД)
     */
    @Query(value = "SELECT * FROM buttons WHERE id=?1", nativeQuery = true)
    ButtonEntity getButtonById(int id);

    /**
     * Возвращает пуговицу по id (вариант 2 - через "мвгию" data jpa)
     */
    ButtonEntity findButtonEntityById(int id);


}
