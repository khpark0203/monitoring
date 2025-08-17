package com.monitoring.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class KafkaMessageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Objects message) {
        try {
            String jsonMessage = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(message);
            kafkaTemplate.send(topic, jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

