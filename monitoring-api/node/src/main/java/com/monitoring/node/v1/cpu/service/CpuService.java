package com.monitoring.node.v1.cpu.service;

import com.monitoring.cpu.Cpu;

public interface CpuService {
    Cpu getCpuInfo();
    int getCpuCores();
    double getCpuUsagePercent();
}
