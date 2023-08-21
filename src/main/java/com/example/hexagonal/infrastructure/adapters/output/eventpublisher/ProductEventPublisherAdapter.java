package com.example.hexagonal.infrastructure.adapters.output.eventpublisher;

import com.example.hexagonal.application.ports.output.ProductEventPublisher;
import com.example.hexagonal.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(ProductCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
