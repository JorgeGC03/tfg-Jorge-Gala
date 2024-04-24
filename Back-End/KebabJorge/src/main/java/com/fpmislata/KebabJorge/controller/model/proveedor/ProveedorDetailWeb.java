package com.fpmislata.KebabJorge.controller.model.proveedor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProveedorDetailWeb {

    int proveedorId;
    String nombre, contacto, direccion, email;

}
