package com.fedina.shop.repositories.jpa;

import com.fedina.shop.entity.BasketEntity;
import com.fedina.shop.entity.ButtonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketJpaRepository extends JpaRepository<BasketEntity, Integer> {
}
