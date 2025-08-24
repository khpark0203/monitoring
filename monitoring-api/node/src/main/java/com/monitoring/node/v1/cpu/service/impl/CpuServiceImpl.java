package com.monitoring.node.v1.cpu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.monitoring.domain.cpu.Cpu;
import com.monitoring.node.v1.cpu.service.CpuService;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Builder
@RequiredArgsConstructor
public class CpuServiceImpl implements CpuService {
    @Override
    public Cpu getCpuInfo() {
        return Cpu.builder()
            .cores(getCpuCores())
            .usagePercent(getCpuUsagePercent())
            .build();
    }

    @Override
    public int getCpuCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public double getCpuUsagePercent() {
        java.lang.management.OperatingSystemMXBean osBean =
            java.lang.management.ManagementFactory.getOperatingSystemMXBean();
        double cpuLoad = -1;
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            cpuLoad = ((com.sun.management.OperatingSystemMXBean) osBean).getProcessCpuLoad();
        }
        if (cpuLoad < 0) {
            return -1; // 값이 사용 불가할 때
        }
        return cpuLoad * 100;
    }
}
