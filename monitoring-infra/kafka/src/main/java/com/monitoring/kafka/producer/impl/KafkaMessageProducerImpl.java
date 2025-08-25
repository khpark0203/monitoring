package com.monitoring.kafka.producer.impl;

import com.monitoring.kafka.message.KafkaMessage;
import com.monitoring.kafka.producer.KafkaMessageProducer;
import com.monitoring.kafka.topic.TopicGettable;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageProducerImpl implements KafkaMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(TopicGettable topicGettable, String key, Object message) {
        if (message instanceof KafkaMessage<?>) {
        } else {
            message = KafkaMessage.builder()
                .payload(message)
                .build();
        }
        kafkaTemplate.send(topicGettable.topic(), key, message);
    }
}

