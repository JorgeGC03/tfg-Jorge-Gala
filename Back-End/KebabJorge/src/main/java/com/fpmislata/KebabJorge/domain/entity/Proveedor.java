package com.fpmislata.KebabJorge.domain.entity;
import com.fpmislata.KebabJorge.validaciones.ValidEmail;
import com.fpmislata.KebabJorge.validaciones.ValidName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Proveedor {

    private int proveedorId;
    @NotNull
    @ValidName
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    private String contacto;
    private String direccion;
    @NotBlank(message = "el correo no puede estar en blanco")
    @ValidEmail
    private String email;


    public Proveedor(String nombre, String contacto, String direccion, String email) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.email = email;
    }

}
