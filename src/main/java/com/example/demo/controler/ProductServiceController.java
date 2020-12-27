package com.example.demo.controler;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;

/**
 * REST API controller.
 */
@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;

    /**
     * Delete a product.
     * @param id id to delete.
     * @return response message.
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
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
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    /**
     * Add a product.
     * @param product product to add.
     * @return response message.
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    /**
     * Get all products.
     * @return all products.
     */
    @RequestMapping(value = "/products")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    /**
     * Get one product with specific id.
     * @param id it to get.
     * @return selected product.
     */
    @RequestMapping(value = "/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getOneProduct(id), HttpStatus.OK);
    }
}
