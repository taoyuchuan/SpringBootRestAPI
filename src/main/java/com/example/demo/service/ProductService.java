package com.example.demo.service;

import java.util.Collection;
import com.example.demo.model.Product;

public interface ProductService {
    void createProduct(Product product);
    void updateProduct(String id, Product product);
    void deleteProduct(String id);
    Collection<Product> getProducts();
    Product getOneProduct(String id);
}
