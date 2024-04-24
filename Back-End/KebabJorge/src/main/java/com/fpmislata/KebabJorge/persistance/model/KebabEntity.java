package com.fpmislata.KebabJorge.persistance.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Data
@Entity
@Table(name = "kebab")
public class KebabEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kebabId;
    private String nombre;
    private String descripcion;
    private double precio;


     @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(
         name = "ingredientes_kebab",
         joinColumns = @JoinColumn(name = "kebabId"),
         inverseJoinColumns = @JoinColumn(name = "ingredientesId")
     )
     private List<IngredientesEntity> ingredientesEntityList;

}
