package com.fpmislata.KebabJorge.controller.model.kebab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class KebabUpdateWEB {

    private int kebabId;
    private String nombre, descripcion, precio;
    private List<Integer> ingredientesIdWeb;

}
