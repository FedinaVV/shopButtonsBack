package com.fedina.shop.repositories.jpa;

import com.fedina.shop.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketJpaRepository extends JpaRepository<BasketEntity, Integer> {

}
