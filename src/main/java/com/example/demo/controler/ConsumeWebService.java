package com.example.demo.controler;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;

/**
 * REST template class to consume REST web services.
 */
@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * Consume GET request for product list.
     * @return Product list.
     */
    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    /**
     * Consume GET request for a specific product.
     * @param id id for selected product.
     * @return Specific product.
     */
    @RequestMapping(value = "/template/products/{id}")
    public String getProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/" + id, HttpMethod.GET, entity, String.class).getBody();
    }

    /**
     * Consume POST request.
     * @param product Product to consume.
     * @return Response message.
     */
    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }

    /**
     * Consume PUT request.
     * @param id id for selected product.
     * @param product Product to consume.
     * @return Response message.
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    /**
     * Consume DELETE request.
     * @param id id for selected product.
     * @return Response message.
     */
    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
