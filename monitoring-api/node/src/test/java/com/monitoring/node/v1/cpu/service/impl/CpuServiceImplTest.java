package com.monitoring.node.v1.cpu.service.impl;

import com.monitoring.cpu.Cpu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CpuServiceImplTest {

    CpuServiceImpl cpuServiceImpl;

    @BeforeEach
    void init() {
        cpuServiceImpl = CpuServiceImpl.builder()
            .build();
    }

    @Nested
    class GetCpuInfo {

        @Nested
        class Success {

            @Test
            void CPU_정보를_가져올_수_있다() {
                // given
                // when
                Cpu sut = cpuServiceImpl.getCpuInfo();

                // then
                assertThat(sut.cores()).isEqualTo(14);
            }
        }
    }
}