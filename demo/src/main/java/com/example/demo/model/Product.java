package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product") // Explicitly define table name
public class Product { // Class name should be PascalCase

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Field name should be camelCase

    @Column(nullable = false, unique = true)
    private String name;


    public Product() {
    }


    public Product(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}