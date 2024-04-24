package com.fpmislata.KebabJorge.domain.repository;

import com.fpmislata.KebabJorge.domain.entity.Ingredientes;

import java.util.List;

public interface IngredientesRepository {

    public List<Ingredientes> getAll();
    public Ingredientes findById(int ingredientesId);
    public Ingredientes insertIngrediente(Ingredientes ingredientes);
    public void deleteIngrediente(Ingredientes ingredientes);
    public Ingredientes updateingredienteById(Ingredientes ingredientes);
}
