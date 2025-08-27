package com.monitoring.kafka.topic;

@FunctionalInterface
public interface TopicProvider {
    String topic();
}
