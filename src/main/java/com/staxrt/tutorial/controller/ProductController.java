package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.Product;
import com.staxrt.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getProducts(){
        List<Product> result = productRepository.findAll();;
        return result;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                         .orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        Product result = productRepository.save(product);
        return result;
    }


    @DeleteMapping("/product/{abc}")
    public Map<String, Boolean> deleteproduct(@PathVariable(value = "abc") Long productId) throws Exception {
        Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
