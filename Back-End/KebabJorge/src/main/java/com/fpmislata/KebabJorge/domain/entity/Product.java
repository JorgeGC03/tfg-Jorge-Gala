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
    
    
    
        private int productoId;
        private String nombre;
        private String descripcion;
        private double precio;
        private int type;
        private String imageUrl;
        private List<Ingredientes> Ingredientes;
    
        public Product(int productoId, String nombre, String descripcion, double precio, int type, String imageUrl) {
            this.productoId = productoId;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.type = type;
            this.imageUrl = imageUrl;
        }
    
        public Product(String nombre, String descripcion, double precio, int type, String imageUrl) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.type = type;
            this.imageUrl = imageUrl;
        }
    
        public Product(int productoId, String nombre, String descripcion, double precio, String imageUrl) {
            this.productoId = productoId;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.imageUrl = imageUrl;
        }
    }
