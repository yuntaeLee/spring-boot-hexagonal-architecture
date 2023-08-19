package com.example.hexagonal.infrastructure.adapters.output.persistence.mapper;

import com.example.hexagonal.domain.model.Product;
import com.example.hexagonal.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
