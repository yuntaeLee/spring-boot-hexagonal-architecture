package com.example.hexagonal.application.ports.output;

import com.example.hexagonal.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);
}
