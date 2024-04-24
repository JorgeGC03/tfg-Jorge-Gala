package com.fpmislata.KebabJorge.domain.repository;

import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAll();
    public List<Product> findAllByType(int type);
    public Product findById(int productoId);
    public Product insert(Product product);
    public void deleteProductById(Product product);
    public Product updateProductById(Product product);
}
