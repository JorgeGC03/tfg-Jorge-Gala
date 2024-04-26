package com.fpmislata.KebabJorge.controller;

import com.fpmislata.KebabJorge.controller.model.kebab.KebabCreateWEB;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabDetailWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabListWeb;
import com.fpmislata.KebabJorge.controller.model.kebab.KebabUpdateWEB;
import com.fpmislata.KebabJorge.controller.model.product.ProductCreateWEB;
import com.fpmislata.KebabJorge.controller.model.product.ProductDetailWeb;
import com.fpmislata.KebabJorge.controller.model.product.ProductListWeb;
import com.fpmislata.KebabJorge.controller.model.product.ProductUpdateWEB;
import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.entity.Product;
import com.fpmislata.KebabJorge.domain.service.IngredientesService;
import com.fpmislata.KebabJorge.domain.service.KebabService;
import com.fpmislata.KebabJorge.domain.service.ProductService;
import com.fpmislata.KebabJorge.http_response.Response;
import com.fpmislata.KebabJorge.mapper.KebabMapper;
import com.fpmislata.KebabJorge.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ProductController.PRODUCTOS)
@RestController
public class ProductController {

    public static final String PRODUCTOS = "/productos";

    @Autowired
    ProductService productService;
    @Autowired
    IngredientesService ingredientesService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Product> product = productService.getAll();
        List<ProductListWeb> productListWeb = product.stream()
                .map(ProductMapper.mapper::toProductListWeb)
                .toList();

        return Response.builder()
                .data(productListWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/type={type}")
    public Response findAllByType(@PathVariable int type) {
        List<Product> products = productService.findAllByType(type);
        List<ProductListWeb> productListWeb = products.stream()
                .map(ProductMapper.mapper::toProductListWeb)
                .toList();

        return Response.builder()
                .data(productListWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{productoId}")
    public Response findById(@PathVariable("productoId") int productoId){
        return new Response( ProductMapper.mapper.toProductDetailWeb(productService.findById(productoId)));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody ProductCreateWEB productCreateWEB){
            ProductDetailWeb productDetailWeb = ProductMapper.mapper.toProductDetailWeb(productService.insert(ProductMapper.mapper.toProduct(productCreateWEB), productCreateWEB.getIngredientesIdWeb()));
        System.out.println(productDetailWeb);
        return new Response(productDetailWeb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{productoId}")
    public void deleteProductById(@PathVariable("productoId") int productoId){
        productService.deleteProductById(productoId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateProductById(@PathVariable("id") int productoId, @RequestBody ProductUpdateWEB productUpdateWEB){
        Product product = ProductMapper.mapper.toProduct(productUpdateWEB);
        product.setProductoId(productoId);
        productService.updateProductById(product, productUpdateWEB.getIngredientesIdWeb());
        ProductDetailWeb productDetailWeb = ProductMapper.mapper.toProductDetailWeb(product);
        return new Response(productDetailWeb);
    }
}
