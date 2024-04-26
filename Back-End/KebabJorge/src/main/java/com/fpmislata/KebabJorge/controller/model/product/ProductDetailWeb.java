package com.fpmislata.KebabJorge.controller.model.product;


import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesListWeb;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class

ProductDetailWeb {

    int productoId;
    private String nombre, descripcion;
    private double precio;
    private String imageUrl;
    List<IngredientesListWeb> ingredientes;
    

}