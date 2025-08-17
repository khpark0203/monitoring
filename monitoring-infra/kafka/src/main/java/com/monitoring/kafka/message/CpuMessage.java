package com.monitoring.kafka.message;

public record CpuMessage(
    int cores,
    double usagePercent
) {
}
