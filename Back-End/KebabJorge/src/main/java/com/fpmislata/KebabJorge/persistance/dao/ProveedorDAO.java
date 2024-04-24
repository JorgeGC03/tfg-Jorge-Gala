package com.fpmislata.KebabJorge.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpmislata.KebabJorge.persistance.model.ProveedorEntity;

public interface ProveedorDAO extends JpaRepository<ProveedorEntity, Integer> {

}
