package com.example.demo.controler;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

/**
 * REST API controller.
 */
@RestController
public class ProductServiceController {
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
     * Delete a product.
     * @param id id to delete.
     * @return response message.
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    /**
     * Update a product.
     * @param id id to update.
     * @param product Contains information for update.
     * @return response message.
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    /**
     * Add a product.
     * @param product product to add.
     * @return response message.
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    /**
     * Get all products.
     * @return all products.
     */
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    /**
     * Get one product with specific id.
     * @param id it to get.
     * @return selected product.
     */
    @RequestMapping(value = "/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable("id") String id) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotFoundException();
        }
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }
}
