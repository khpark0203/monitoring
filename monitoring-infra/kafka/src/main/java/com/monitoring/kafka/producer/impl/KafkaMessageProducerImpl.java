package com.monitoring.kafka.producer.impl;

import com.monitoring.kafka.message.KafkaMessage;
import com.monitoring.kafka.message.KafkaPayloadProvider;
import com.monitoring.kafka.producer.KafkaMessageProducer;
import com.monitoring.kafka.topic.TopicProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageProducerImpl implements KafkaMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(TopicProvider topicProvider, String key, KafkaPayloadProvider message) {
        KafkaMessage<?> kafkaMessage = KafkaMessage.builder()
            .payload(message.payload())
            .build();
        kafkaTemplate.send(topicProvider.topic(), key, kafkaMessage);
    }
}

