package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;
import com.example.demo.repositorey.productRepository;

import java.util.List;

@Service
public class productService {

    private final productRepository repository;

    public productService(productRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Product createProduct(Product Product) {
        if (repository.existsByName(Product.getName())) {
            throw new RuntimeException("Product name already exists");
        }
        return repository.save(Product);
    }

    @Transactional
    public Product updateProductName(Long id, String newName) {
        Product Product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " does not exist!"));
        Product.setName(newName);
        return repository.save(Product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " does not exist!"));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
