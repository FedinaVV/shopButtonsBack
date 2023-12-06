package com.fedina.shop.repositories.implementations;

import com.fedina.shop.entity.BasketEntity;
import com.fedina.shop.entity.ButtonEntity;
import com.fedina.shop.repositories.jpa.BasketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class BasketRepositoryImpl {
    private final BasketJpaRepository basketJpaRepository;

    @Autowired
    public BasketRepositoryImpl(BasketJpaRepository basketJpaRepository) {
        this.basketJpaRepository = basketJpaRepository;
    }

    public BasketEntity createButtonInBasket(BasketEntity basketEntity) {
        basketEntity.setCreatedAt(OffsetDateTime.now());
        return basketJpaRepository.save(basketEntity);
    }

    public List<BasketEntity> getBaskets() {
        return basketJpaRepository.findAll();
    }
    public void deleteByIdFromBasket(int id) {
        basketJpaRepository.deleteById(id);
    }
}
