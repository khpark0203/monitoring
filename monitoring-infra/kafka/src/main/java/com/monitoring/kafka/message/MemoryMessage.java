package com.monitoring.kafka.message;

import lombok.Builder;

@Builder
public record MemoryMessage(
    int usage
) {
}
