package com.monitoring.node.v1.cpu.service;

import com.monitoring.domain.cpu.Cpu;

public interface CpuService {
    Cpu getCpuInfo();
    int getCpuCores();
    double getCpuUsagePercent();
}
