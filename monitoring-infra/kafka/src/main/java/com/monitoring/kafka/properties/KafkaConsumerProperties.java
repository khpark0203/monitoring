package com.monitoring.kafka.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.kafka.consumer")
public record KafkaConsumerProperties(
    String bootstrapServers,
    String groupId
) {
}
