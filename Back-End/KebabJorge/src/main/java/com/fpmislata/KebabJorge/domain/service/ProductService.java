package com.fpmislata.KebabJorge.domain.service;

import com.fpmislata.KebabJorge.domain.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public List<Product> findAllByType(int type);
    public Product findById(int productoId);
    public Product insert(Product product, List<Integer> ingredientesId);
    void deleteProductById(int productoId);
    public Product updateProductById(Product product, List<Integer> ingredientesId);


}
