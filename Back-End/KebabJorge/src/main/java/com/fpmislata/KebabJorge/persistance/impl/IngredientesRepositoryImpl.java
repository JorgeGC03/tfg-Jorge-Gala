package com.fpmislata.KebabJorge.persistance.impl;

import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.repository.IngredientesRepository;
import com.fpmislata.KebabJorge.mapper.IngredientesMapper;
import com.fpmislata.KebabJorge.persistance.dao.IngredientesDAO;
import com.fpmislata.KebabJorge.persistance.model.IngredientesEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientesRepositoryImpl implements IngredientesRepository {

    @Autowired
    IngredientesDAO ingredientesDAO;

    @Override
    public List<Ingredientes> getAll() {
        List<IngredientesEntity> ingredientesEntity = ingredientesDAO.findAll();
        return IngredientesMapper.mapper.toIngredientesList(ingredientesEntity);
    }

    @Override
    public Ingredientes findById(int ingredientesId) {
        IngredientesEntity ingredientesEntity = ingredientesDAO.findById(ingredientesId).orElse(null);
        return IngredientesMapper.mapper.toIngredientes(ingredientesEntity);
    }
    @Transactional
    @Override
    public Ingredientes insertIngrediente(Ingredientes ingredientes) {
        IngredientesEntity ingredientesEntity = ingredientesDAO.save(IngredientesMapper.mapper.toIngredientesEntity(ingredientes));
        return IngredientesMapper.mapper.toIngredientes(ingredientesEntity);
    }
    @Transactional
    @Override
    public void deleteIngrediente(Ingredientes ingredientes) {
        ingredientesDAO.delete(IngredientesMapper.mapper.toIngredientesEntity(ingredientes));
    }

    @Transactional
    @Override
    public Ingredientes updateingredienteById(Ingredientes ingredientes) {
        IngredientesEntity ingredientesEntity = ingredientesDAO.save(IngredientesMapper.mapper.toIngredientesEntity(ingredientes));
        return  IngredientesMapper.mapper.toIngredientes(ingredientesEntity);
    }


}
