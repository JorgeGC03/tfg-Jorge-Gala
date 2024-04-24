package com.fpmislata.KebabJorge.persistance.model;

import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Mapping;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Data
@Entity
@Table(name = "ingredientes")

public class IngredientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientesId;
    @Column(name = "nombre")
    private String nombreIngrediente;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedorId")
    private ProveedorEntity proveedorEntity;



}