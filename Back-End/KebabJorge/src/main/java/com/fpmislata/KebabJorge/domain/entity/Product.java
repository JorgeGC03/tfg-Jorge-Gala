package com.fpmislata.KebabJorge.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    public Product(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    private int productoId;
    private String nombre;
    private String descripcion;
    private double precio;
    private int type;
    private List<Ingredientes> Ingredientes;

    public Product(int productoId, String nombre, String descripcion, double precio, int type) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.type = type;
    }

    public Product(String nombre, String descripcion, double precio, int type) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.type = type;
    }

    public Product(int productoId, String nombre, String descripcion, double precio) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
