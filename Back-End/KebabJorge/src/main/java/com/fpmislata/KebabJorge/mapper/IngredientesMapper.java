package com.fpmislata.KebabJorge.mapper;

import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesCreateWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesDetailWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesListWeb;
import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesUpdateWeb;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorDetailWeb;
import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.entity.Proveedor;
import com.fpmislata.KebabJorge.persistance.model.IngredientesEntity;
import com.fpmislata.KebabJorge.persistance.model.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientesMapper {

    IngredientesMapper mapper = Mappers.getMapper(IngredientesMapper.class);

    //@Mapping(target = "proveedor", expression = "java(mapProveedorEntityToProveedor(ingredientesEntity.getProveedorEntity()))")
    @Mapping(target = "proveedor", source = "proveedorEntity", qualifiedByName = "proveedorEntityToProveedor")
    Ingredientes toIngredientes(IngredientesEntity ingredientesEntity);


    IngredientesListWeb toIngredientesListWeb(Ingredientes ingredientes);

    @Mapping(target = "proveedor", source = "proveedorEntity", qualifiedByName = "proveedorEntityToProveedor")
    List<Ingredientes> toIngredientesList(List<IngredientesEntity> ingredientesEntity);

    @Mapping(target = "proveedorDetailWeb", expression = "java(mapProveedorToProveedorDetailWeb(ingredientes.getProveedor()))")
    IngredientesDetailWeb toIngredientesDetailWeb(Ingredientes ingredientes);

    @Named("proveedorEntityToProveedor")
    default Proveedor mapProveedorEntityToProveedor(ProveedorEntity proveedorEntity) {
        return ProveedorMapper.mapper.toProveedor(proveedorEntity);
    }

    @Named("ProveedorToProveedorDetailWeb")
    default ProveedorDetailWeb mapProveedorToProveedorDetailWeb(Proveedor proveedor) {
        return ProveedorMapper.mapper.toProveedorDetailWeb(proveedor);
    }

    @Mapping(target = "proveedorEntity", expression = "java(ProveedorMapper.mapper.toProveedorEntity(ingredientes.getProveedor()))")
    IngredientesEntity toIngredientesEntity (Ingredientes ingredientes);

    @Mapping(target = "proveedor", ignore = true)
    Ingredientes toIngredientes (IngredientesUpdateWeb ingredientesUpdateWeb);
    @Mapping(target = "proveedor", ignore = true)
    Ingredientes toIngredientes (IngredientesCreateWeb ingredientesCreateWeb);
}