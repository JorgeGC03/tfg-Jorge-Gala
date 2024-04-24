package com.fpmislata.KebabJorge.mapper;

import com.fpmislata.KebabJorge.controller.model.kebab.KebabCreateWEB;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabDetailWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabListWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabUpdateWEB;
import com.fpmislata.KebabJorge.controller.model.product.ProductCreateWEB;
import com.fpmislata.KebabJorge.controller.model.product.ProductDetailWeb;
import com.fpmislata.KebabJorge.controller.model.product.ProductListWeb;
import com.fpmislata.KebabJorge.controller.model.product.ProductUpdateWEB;
import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Product;
import com.fpmislata.KebabJorge.persistance.model.IngredientesEntity;
import com.fpmislata.KebabJorge.persistance.model.KebabEntity;
import com.fpmislata.KebabJorge.persistance.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    List<Product> toProductList (List<ProductEntity> productEntity);
    @Mapping(source = "productoId", target = "productoId")
    ProductListWeb toProductListWeb(Product product);
    ProductDetailWeb toProductDetailWeb(Product product);

    @Mapping(target = "ingredientes", expression = "java(mapIngredientesEntityToIngredientes(productEntity.getIngredientesEntityList()))")
    Product toProduct(ProductEntity productEntity);

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
    Product toProduct (ProductCreateWEB productCreateWEB);

    @Mapping(target = "ingredientes", ignore = true)
    Product toProduct (ProductUpdateWEB productUpdateWeb);

    @Mapping(target = "ingredientesEntityList", expression = "java(mapIngredientesListToIngredientesEntitiesList(product.getIngredientes()))")
    ProductEntity toProductEntity (Product product);

    @Named("IngredientesListToIngredientesEntitiesList")
    default List<IngredientesEntity>mapIngredientesListToIngredientesEntitiesList(List<Ingredientes> ingredientes){
        return ingredientes.stream()
                .map(IngredientesMapper.mapper::toIngredientesEntity)
                .toList();
    }



}
