package com.monitoring.node.v1.cpu.consumer;

import com.monitoring.kafka.message.CpuMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CpuConsumer {
    @KafkaListener(
        topics = "cpuinfok",
        groupId = "monitoring-cpu",
        containerFactory = "cpuMessageConcurrentKafkaListenerContainerFactory"
    )
    public void listenOrderTopic(CpuMessage message) {
        System.out.printf("Received MessageA from 'order-topic': %s%n", message);
        // MessageA에 대한 비즈니스 로직 처리...
    }
}
