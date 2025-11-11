package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.productService;
import com.example.demo.model.Product;
import java.util.List;

@RestController
@RequestMapping("/products") 
public class productsController {

    private final productService productsService;

    public productsController(productService productsService ){
        this.productsService = productsService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productsService.createProduct(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productsService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public Product updateProductName(@PathVariable Long id, @RequestBody String newName){
        return productsService.updateProductName(id, newName);
    }
}
