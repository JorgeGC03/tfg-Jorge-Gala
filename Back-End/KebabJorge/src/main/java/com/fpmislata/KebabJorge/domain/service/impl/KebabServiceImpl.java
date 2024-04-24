package com.fpmislata.KebabJorge.domain.service.impl;

import java.util.List;

import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.repository.KebabRepository;
import com.fpmislata.KebabJorge.domain.service.KebabService;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@Service
public class KebabServiceImpl implements KebabService{

    @Autowired
    KebabRepository kebabRepository;

    @Autowired
    IngredientesRepository ingredientesRepository;

    @Override
    public List<Kebab> getAll() {

        return kebabRepository.getAll();
    }

    @Override
    public Kebab findById(int kebabId) {
        return kebabRepository.findById(kebabId);

    }

    @Override
    public Kebab insert(Kebab kebab, List<Integer> ingredientesId) {
        validate(kebab);
        List<Ingredientes> ingredientes = ingredientesId.stream()
                .map(ingredienteId -> ingredientesRepository.findById(ingredienteId))
                .toList();
        kebab.setIngredientes(ingredientes);
        return kebabRepository.insert(kebab);
    }

    @Override
    public void deleteKebabById(int kebabId){
        Kebab kebab = kebabRepository.findById(kebabId);
        kebabRepository.deleteKebabById(kebab);
    }

    @Override
    public Kebab updateKebabById(Kebab kebab, List<Integer> ingredientesId){
        validate(kebab);
        List<Ingredientes> ingredientes =
                ingredientesId.stream()
                        .map(id -> ingredientesRepository.findById(id))
                        .toList();
        kebab.setIngredientes(ingredientes);
        return kebabRepository.updateKebabById(kebab);
    }
}
