package com.shoptee.shoptee.service;

import com.shoptee.shoptee.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    void deleteById(Integer id);

    Product updateProduct(Product product);
}
