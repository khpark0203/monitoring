package com.monitoring.kafka.message;

import lombok.Builder;

@Builder
public record KafkaMessage<T>(
    T payload
) {
}
