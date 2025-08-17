package com.monitoring.cpu;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Getter
public class Cpu {
    private int cores;
    private double usagePercent;
}
