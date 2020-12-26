package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;

/**
 * Provide REST service to ProductServiceController
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    /**
     * POST service.
     * Add a product.
     * @param product product to add.
     */
    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    /**
     * PUT service.
     * Update a product.
     * @param id id for update.
     * @param product producr information to update.
     */
    @Override
    public void updateProduct(String id, Product product) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    /**
     * DELETE service.
     * @param id id to delete.
     */
    @Override
    public void deleteProduct(String id) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
    }

    /**
     * GET service.
     * @return All prudocts.
     */
    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }

    /**
     * GET service
     * @param id Product id to be returned.
     * @return A selected product.
     */
    @Override
    public Product getOneProduct(String id){
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        return productRepo.get(id);
    }
}
