package com.fpmislata.KebabJorge.persistance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productoId;
    private String nombre;
    private String descripcion;
    private double precio;
    @Column(name = "tipo")
    private int type;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "producto_ingrediente",
            joinColumns = @JoinColumn(name = "productoId"),
            inverseJoinColumns = @JoinColumn(name = "ingredientesId")
    )
    private List<IngredientesEntity> ingredientesEntityList;

}