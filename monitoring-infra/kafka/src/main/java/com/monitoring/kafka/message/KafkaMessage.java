package com.monitoring.kafka.message;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;

@Builder
public record KafkaMessage<T>(

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    T payload
) {
}
