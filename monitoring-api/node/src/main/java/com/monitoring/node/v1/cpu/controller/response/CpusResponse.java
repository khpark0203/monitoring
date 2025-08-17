package com.monitoring.node.v1.cpu.controller.response;

import com.monitoring.cpu.Cpu;

public record CpusResponse(
    int cores,
    double usagePercent
) {

    public static CpusResponse from(Cpu cpu) {
        return new CpusResponse(
            cpu.cores(),
            cpu.usagePercent()
        );
    }
}