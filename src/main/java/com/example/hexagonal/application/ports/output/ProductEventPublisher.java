package com.example.hexagonal.application.ports.output;

import com.example.hexagonal.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {

    void publishProductCreatedEvent(ProductCreatedEvent event);
}
