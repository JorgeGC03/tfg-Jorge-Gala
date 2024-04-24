package com.fpmislata.KebabJorge.persistance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpmislata.KebabJorge.persistance.model.KebabEntity;

@Repository
public interface KebabDAO extends JpaRepository<KebabEntity, Integer> {
}
