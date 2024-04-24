package com.fpmislata.KebabJorge.controller.model.ingredientes;
import com.fpmislata.KebabJorge.controller.model.proveedor.ProveedorDetailWeb;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class IngredientesDetailWeb{

    int ingredientesId;
    String nombreIngrediente, descripcion;
    ProveedorDetailWeb proveedorDetailWeb;

}