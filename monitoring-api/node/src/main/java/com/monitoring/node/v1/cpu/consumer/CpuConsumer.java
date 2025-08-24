package com.monitoring.node.v1.cpu.consumer;

import com.monitoring.kafka.message.CpuMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CpuConsumer {
    @KafkaListener(topics = "cpuinfo")
    public void listenOrderTopic(CpuMessage message) {
        System.out.printf("Received MessageA from 'order-topic': %s%n", message);
    }
}
