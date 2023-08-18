package com.example.hexagonal.application.ports.input;

import com.example.hexagonal.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}