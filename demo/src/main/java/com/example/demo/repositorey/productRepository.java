package com.example.demo.repositorey;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}
