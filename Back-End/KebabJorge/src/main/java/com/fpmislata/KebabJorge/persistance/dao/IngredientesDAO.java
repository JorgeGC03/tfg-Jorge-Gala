package com.fpmislata.KebabJorge.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.KebabJorge.persistance.model.IngredientesEntity;

public interface IngredientesDAO extends JpaRepository<IngredientesEntity, Integer> {

}
