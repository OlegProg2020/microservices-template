package com.example.microservice2.messaging.producer.implementation;

import com.example.microservice2.messaging.producer.AuditNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditNotificationServiceImpl implements AuditNotificationService {

    @Value("${spring.application.name}")
    private String applicationName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendRequestInformation(String information) {
        information = "app: " +
                applicationName +
                ", " +
                information;

        kafkaTemplate.send("audit.topic", information);
    }

}
