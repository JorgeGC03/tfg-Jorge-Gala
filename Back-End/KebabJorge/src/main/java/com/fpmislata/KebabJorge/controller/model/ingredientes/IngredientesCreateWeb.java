package com.fpmislata.KebabJorge.controller.model.ingredientes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class IngredientesCreateWeb {

    String nombreIngrediente, descripcion;
    private int proveedorIdWeb;
}
