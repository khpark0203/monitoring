package com.monitoring.node.v1.cpu.consumer;

import com.monitoring.domain.cpu.Cpu;
import com.monitoring.domain.cpu.event.CpuEvent;
import com.monitoring.kafka.message.CpuMessage;
import com.monitoring.kafka.message.KafkaMessage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CpuConsumer {

    private final CpuEvent cpuEvent;

    @KafkaListener(topics = "#{T(com.monitoring.kafka.topic.Topic).CPU.topic()}")
    public void cpu(
        @Header(KafkaHeaders.RECEIVED_KEY) String key,
        KafkaMessage<CpuMessage> message
    ) {
        log.info("Received payload from topic: {}", key);
        log.info("Received payload from topic: {}", message.payload().cores());
        log.info("Received payload from topic: {}", message.payload().usagePercent());
    }

    @PostConstruct
    void init() {
        cpuEvent.sendIncreaseUsage(Cpu.builder()
            .cores(1)
            .usagePercent(12.5)
            .build());
    }
}
