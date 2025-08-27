package com.monitoring.kafka.message;

import com.monitoring.domain.cpu.Cpu;
import com.monitoring.domain.memory.Memory;
import lombok.Builder;

@Builder
public record CpuMessage(
    int cores,
    double usagePercent
) {

    public static CpuMessage from(Cpu cpu) {
        return CpuMessage.builder()
            .cores(cpu.cores())
            .usagePercent(cpu.usagePercent())
            .build();
    }
}
