package com.fpmislata.KebabJorge.domain.entity;

import java.util.List;

import com.fpmislata.KebabJorge.validaciones.ValidDescription;
import com.fpmislata.KebabJorge.validaciones.ValidName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Kebab {

    private int kebabId;
    @ValidName
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    @ValidDescription
    @NotBlank(message = "La descripcion no puede pasar los 100 caracteres ni estar en blanco")
    private String descripcion;
    @NotBlank(message = "El precio no puede ser menor que 5 ni estar en blanco")
    @Min(value = 2, message = "El precio debe ser mayor a 2 euros")
    private double precio;
    private List<Ingredientes> Ingredientes;


     public Kebab(int kebabId, String nombre, String descripcion, double precio) {
        this.kebabId = kebabId;
        this.nombre = nombre;
        this.descripcion = descripcion;
         this.precio = precio;
     }


    public Kebab(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    

}
