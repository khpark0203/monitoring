package com.monitoring.kafka.producer;

import com.monitoring.kafka.message.KafkaPayloadProvider;
import com.monitoring.kafka.topic.TopicProvider;

public interface KafkaMessageProducer {
    void send(TopicProvider topicProvider, String key, KafkaPayloadProvider message);
}