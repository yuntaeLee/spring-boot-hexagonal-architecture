package com.example.hexagonal.infrastructure.adapters.input.rest.mapper;

import com.example.hexagonal.domain.model.Product;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import com.example.hexagonal.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);
}
