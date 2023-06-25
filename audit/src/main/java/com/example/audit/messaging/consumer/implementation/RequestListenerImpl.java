package com.example.audit.messaging.consumer.implementation;

import com.example.audit.messaging.consumer.RequestListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestListenerImpl implements RequestListener {

    @Override
    @KafkaListener(topics = {"audit.topic"})
    public void handle(String requestInformation) {
        log.info("request: {}", requestInformation);
    }
}
