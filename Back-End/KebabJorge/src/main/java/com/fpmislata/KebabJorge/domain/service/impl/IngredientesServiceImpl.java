package com.fpmislata.KebabJorge.domain.service.impl;

import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.domain.repository.IngredientesRepository;
import com.fpmislata.KebabJorge.domain.repository.KebabRepository;
import com.fpmislata.KebabJorge.domain.repository.ProveedorRepository;
import com.fpmislata.KebabJorge.domain.service.IngredientesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@Service
public class IngredientesServiceImpl implements IngredientesService {

    @Autowired
    IngredientesRepository ingredientesRepository;
    @Autowired
    ProveedorRepository proveedorRepository;


    @Override
    public List<Ingredientes> getAll() {
        return ingredientesRepository.getAll();
    }

    @Override
    public Ingredientes findById(int ingredientesId) {
        return ingredientesRepository.findById(ingredientesId);
    }
    @Transactional
    @Override
    public Ingredientes insertIngrediente(Ingredientes ingredientes, int proveedorId) {
        validate(ingredientes);
        Proveedor proveedor = proveedorRepository.findById(proveedorId);
        ingredientes.setProveedor(proveedor);
        return ingredientesRepository.insertIngrediente(ingredientes);
    }
    @Transactional
    @Override
    public void deleteIngrediente(int ingredientesId) {
        Ingredientes ingredientes = ingredientesRepository.findById(ingredientesId);
        ingredientesRepository.deleteIngrediente(ingredientes);
    }
    @Transactional
    @Override
    public Ingredientes updateIngredienteById(Ingredientes ingredientes, int proveedorId) {
        validate(ingredientes);
        Proveedor proveedor = proveedorRepository.findById(proveedorId);
        ingredientes.setProveedor(proveedor);
        return ingredientesRepository.updateingredienteById(ingredientes);

    }

}
