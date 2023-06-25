package com.example.microservice2.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory;

    @PostConstruct
    public void configureKafka() {

        kafkaTemplate.setObservationEnabled(true);
        kafkaListenerContainerFactory.getContainerProperties().setObservationEnabled(true);
    }

}
