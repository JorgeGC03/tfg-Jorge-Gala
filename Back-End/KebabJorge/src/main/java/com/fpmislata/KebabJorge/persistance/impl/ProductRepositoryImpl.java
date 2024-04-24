package com.fpmislata.KebabJorge.persistance.impl;

import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Product;
import com.fpmislata.KebabJorge.domain.repository.ProductRepository;
import com.fpmislata.KebabJorge.mapper.KebabMapper;
import com.fpmislata.KebabJorge.mapper.ProductMapper;
import com.fpmislata.KebabJorge.persistance.dao.KebabDAO;
import com.fpmislata.KebabJorge.persistance.dao.ProductDAO;
import com.fpmislata.KebabJorge.persistance.model.KebabEntity;
import com.fpmislata.KebabJorge.persistance.model.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = productDAO.findAll();
        return ProductMapper.mapper.toProductList(productEntities);
    }

    @Override
    public List<Product> findAllByType(int type) {
        List<ProductEntity> productEntities = productDAO.findByType(type);
        return ProductMapper.mapper.toProductList(productEntities);
    }

    @Override
    public Product findById(int productoId) {

        ProductEntity productEntity = productDAO.findById(productoId).orElse(null);
        return ProductMapper.mapper.toProduct(productEntity);}

    @Transactional
    @Override
    public Product insert(Product product) {
        ProductEntity productEntity = productDAO.save(ProductMapper.mapper.toProductEntity(product));
        return ProductMapper.mapper.toProduct(productEntity);
    }

    @Transactional
    @Override
    public void deleteProductById(Product product){
        productDAO.delete(ProductMapper.mapper.toProductEntity(product));
    }

    @Transactional
    @Override
    public Product updateProductById(Product product){
        ProductEntity productEntity = productDAO.save(ProductMapper.mapper.toProductEntity(product));
        return ProductMapper.mapper.toProduct(productEntity);
    }
}


