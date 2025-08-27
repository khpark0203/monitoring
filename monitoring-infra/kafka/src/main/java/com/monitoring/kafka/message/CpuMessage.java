package com.monitoring.kafka.message;

import com.monitoring.domain.cpu.Cpu;
import lombok.Builder;

@Builder
public record CpuMessage(
    int cores,
    double usagePercent
) implements KafkaPayloadProvider {

    public static CpuMessage from(Cpu cpu) {
        return CpuMessage.builder()
            .cores(cpu.cores())
            .usagePercent(cpu.usagePercent())
            .build();
    }

    @Override
    public Object payload() {
        return this;
    }
}
