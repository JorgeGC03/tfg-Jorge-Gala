package com.fpmislata.KebabJorge.persistance.dao;

import com.fpmislata.KebabJorge.persistance.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByType(int type);
}
