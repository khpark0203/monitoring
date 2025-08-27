package com.monitoring.kafka.event.impl;

import com.monitoring.domain.cpu.Cpu;
import com.monitoring.domain.cpu.event.CpuEvent;
import com.monitoring.kafka.message.CpuMessage;
import com.monitoring.kafka.producer.KafkaMessageProducer;
import com.monitoring.kafka.topic.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CpuEventImpl implements CpuEvent {

    private final KafkaMessageProducer kafkaMessageProducer;

    @Override
    public void sendIncreaseUsage(Cpu cpu) {
        kafkaMessageProducer.send(Topic.CPU, "1", CpuMessage.from(cpu));
    }
}
