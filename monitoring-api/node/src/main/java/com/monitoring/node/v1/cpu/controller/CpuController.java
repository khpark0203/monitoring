package com.monitoring.node.v1.cpu.controller;

import com.monitoring.domain.cpu.Cpu;
import com.monitoring.node.v1.cpu.controller.response.CpusResponse;
import com.monitoring.node.v1.cpu.service.CpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cpus")
@RequiredArgsConstructor
public class CpuController {

    private final CpuService cpuService;

    @GetMapping("")
    public ResponseEntity<CpusResponse> cpu() {

        Cpu cpuInfo = cpuService.getCpuInfo();

        return ResponseEntity.ok(CpusResponse.from(cpuInfo));
    }
}
