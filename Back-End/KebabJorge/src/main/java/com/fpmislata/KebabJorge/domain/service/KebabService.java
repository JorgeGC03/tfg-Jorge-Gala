package com.fpmislata.KebabJorge.domain.service;

import java.util.List;

import com.fpmislata.KebabJorge.domain.entity.Kebab;

public interface KebabService {
    public List<Kebab> getAll();
    public Kebab findById(int kebabId);
    public Kebab insert(Kebab kebab, List<Integer> ingredientesId);
    public void deleteKebabById(int kebabId);
    public Kebab updateKebabById(Kebab kebab, List<Integer> ingredientesId);
}

