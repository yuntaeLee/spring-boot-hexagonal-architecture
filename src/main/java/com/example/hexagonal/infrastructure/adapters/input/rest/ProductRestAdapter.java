package com.example.hexagonal.infrastructure.adapters.input.rest;

import com.example.hexagonal.application.ports.input.CreateProductUseCase;
import com.example.hexagonal.application.ports.input.GetProductUseCase;
import com.example.hexagonal.domain.model.Product;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import com.example.hexagonal.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final ProductRestMapper productRestMapper;

    @PostMapping("/products")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        Product product = productRestMapper.toProduct(productCreateRequest);
        product = createProductUseCase.createProduct(product);
        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable Long id) {
        Product product = getProductUseCase.getProductById(id);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }
}
