package com.fpmislata.KebabJorge.controller.model.kebab;


import java.util.List;

import com.fpmislata.KebabJorge.controller.model.ingredientes.IngredientesListWeb;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class

KebabDetailWeb {

    int kebabId; 
    String nombre, descripcion, precio;
    List<IngredientesListWeb> ingredientes;
    

}