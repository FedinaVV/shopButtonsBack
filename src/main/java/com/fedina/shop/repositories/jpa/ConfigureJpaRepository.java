package com.fedina.shop.repositories.jpa;

import com.fedina.shop.entity.ConfigureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigureJpaRepository extends JpaRepository<ConfigureEntity, Integer> {
    @Query(value = "SELECT * FROM configures", nativeQuery = true)
    List<ConfigureEntity> getAllConfigs();

    List<ConfigureEntity> findAll();

    @Query(value = "SELECT * FROM configures where id = ?1", nativeQuery = true)
    ConfigureEntity getConfigById(Integer id);

    ConfigureEntity findConfigureEntityById(Integer id);

}
