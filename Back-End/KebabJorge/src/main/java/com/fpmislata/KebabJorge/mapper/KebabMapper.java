package com.fpmislata.KebabJorge.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.KebabJorge.controller.model.kebab.KebabCreateWEB;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabDetailWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabUpdateWEB;
import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.persistance.model.IngredientesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.fpmislata.KebabJorge.controller.model.kebab.KebabListWeb;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.persistance.model.KebabEntity;

@Mapper(componentModel = "spring")
public interface KebabMapper {

    KebabMapper mapper = Mappers.getMapper(KebabMapper.class);

    List<Kebab> toKebabList (List<KebabEntity> kebabEntity);
    KebabListWeb toKebabListWeb(Kebab kebab);
    KebabDetailWeb toKebabDetailWeb(Kebab kebab);

    @Mapping(target = "ingredientes", expression = "java(mapIngredientesEntityToIngredientes(kebabEntity.getIngredientesEntityList()))")
    Kebab toKebab(KebabEntity kebabEntity);

    @Named("ingredientesEntityToIngredientes")
    default List<Ingredientes> mapIngredientesEntityToIngredientes(List<IngredientesEntity> ingredientesEntities) {
        if (ingredientesEntities == null) {
            return null;
        }

        return ingredientesEntities.stream()
                .map(IngredientesMapper.mapper::toIngredientes)
                .toList();
    }

    @Mapping(target = "ingredientes", ignore = true)
    Kebab toKebab (KebabCreateWEB kebabCreateWEB);

    @Mapping(target = "ingredientes", ignore = true)
    Kebab toKebab (KebabUpdateWEB kebabUpdateWeb);

    @Mapping(target = "ingredientesEntityList", expression = "java(mapIngredientesListToIngredientesEntitiesList(kebab.getIngredientes()))")
    KebabEntity toKebabEntity (Kebab kebab);

    @Named("IngredientesListToIngredientesEntitiesList")
    default List<IngredientesEntity>mapIngredientesListToIngredientesEntitiesList(List<Ingredientes> ingredientes){
        return ingredientes.stream()
                .map(IngredientesMapper.mapper::toIngredientesEntity)
                .toList();
    }



}
