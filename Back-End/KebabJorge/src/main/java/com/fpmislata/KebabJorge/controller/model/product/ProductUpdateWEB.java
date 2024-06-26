package com.fpmislata.KebabJorge.controller.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateWEB {

    private int productoId;
    private String nombre, descripcion;
    private double precio;
    private int type;
    private String imageUrl;
    private List<Integer> ingredientesIdWeb;

}
