package com.fpmislata.KebabJorge.domain.entity;

import com.fpmislata.KebabJorge.validaciones.ValidDescription;
import com.fpmislata.KebabJorge.validaciones.ValidName;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor


public class Ingredientes {

    private int ingredientesId;
    @ValidName
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombreIngrediente;
    @ValidDescription
    @NotBlank(message = "La descripcion no puede pasar los 100 caracteres ni estar en blanco")
    private String descripcion;
    private Proveedor proveedor;


    public Ingredientes(int ingredientesId, String nombreIngrediente, String descripcion) {
        this.ingredientesId = ingredientesId;
        this.nombreIngrediente = nombreIngrediente;
        this.descripcion = descripcion;
    }


    public Ingredientes(String nombreIngrediente, String descripcion) {
        this.nombreIngrediente = nombreIngrediente;
        this.descripcion = descripcion;
    }

}
