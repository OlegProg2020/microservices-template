package com.example.microservice1.messaging.producer.implementation;

import com.example.microservice1.messaging.producer.AuditNotificationService;
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
        StringBuilder builder = new StringBuilder();
        builder.append("app: ")
                .append(applicationName)
                .append(", request information: ")
                .append(information);

        kafkaTemplate.send("audit.topic", builder.toString());
    }

}
