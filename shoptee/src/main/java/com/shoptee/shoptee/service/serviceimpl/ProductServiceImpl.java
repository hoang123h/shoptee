package com.shoptee.shoptee.service.serviceimpl;

import com.shoptee.shoptee.entity.Product;
import com.shoptee.shoptee.repository.ProductRepository;
import com.shoptee.shoptee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Product currentProduct = getProductById(product.getId());
        if (currentProduct != null) {
            currentProduct.setName(product.getName());
            currentProduct.setImage(product.getImage());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setCreateDate(product.getCreateDate());
            currentProduct.setAvailable(product.isAvailable());
            currentProduct.setCategory(product.getCategory());
            return productRepository.save(currentProduct);
        }
        return null;
    }
}
