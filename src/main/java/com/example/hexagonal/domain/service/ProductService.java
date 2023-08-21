package com.example.hexagonal.domain.service;

import com.example.hexagonal.application.ports.input.CreateProductUseCase;
import com.example.hexagonal.application.ports.input.GetProductUseCase;
import com.example.hexagonal.application.ports.output.ProductEventPublisher;
import com.example.hexagonal.application.ports.output.ProductOutputPort;
import com.example.hexagonal.domain.event.ProductCreatedEvent;
import com.example.hexagonal.domain.exception.ProductNotFound;
import com.example.hexagonal.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private ProductOutputPort productOutputPort;
    private ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreatedEvent(new ProductCreatedEvent(product.getId(), LocalDateTime.now()));
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productOutputPort.getProductById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }
}
