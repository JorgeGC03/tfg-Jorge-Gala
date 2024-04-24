package com.fpmislata.KebabJorge.domain.service.impl;

import com.fpmislata.KebabJorge.domain.entity.Ingredientes;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Product;
import com.fpmislata.KebabJorge.domain.repository.IngredientesRepository;
import com.fpmislata.KebabJorge.domain.repository.ProductRepository;
import com.fpmislata.KebabJorge.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fpmislata.KebabJorge.validaciones.Validation.validate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IngredientesRepository ingredientesRepository;

    @Override
    public List<Product> getAll() {

        return productRepository.getAll();
    }

    @Override
    public List<Product> findAllByType(int type) {
        return productRepository.findAllByType(type);
    }

    @Override
    public Product findById(int productoId) {
        return productRepository.findById(productoId);
    }

    @Override
    public Product insert(Product product, List<Integer> ingredientesId) {
        List<Ingredientes> ingredientes = ingredientesId.stream()
                .map(ingredienteId -> ingredientesRepository.findById(ingredienteId))
                .toList();
        product.setIngredientes(ingredientes);
        return productRepository.insert(product);
}

    @Override
    public void deleteProductById(int productoId){
        Product product = productRepository.findById(productoId);
        productRepository.deleteProductById(product);
    }

    @Override
    public Product updateProductById(Product product, List<Integer> ingredientesId){
        List<Ingredientes> ingredientes =
                ingredientesId.stream()
                        .map(id -> ingredientesRepository.findById(id))
                        .toList();
        product.setIngredientes(ingredientes);
        return productRepository.updateProductById(product);
    }
}

