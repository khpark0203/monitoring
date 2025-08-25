package com.monitoring.domain.cpu.event;

import com.monitoring.domain.cpu.Cpu;

public interface CpuEvent {
    void sendIncreaseUsage(Cpu cpu);
}
