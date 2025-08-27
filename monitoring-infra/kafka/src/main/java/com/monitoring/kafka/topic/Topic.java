package com.monitoring.kafka.topic;

public enum Topic implements TopicProvider {
    CPU("cpu")

    ;

    private final String topic;

    Topic(String topic) {
        this.topic = topic;
    }

    @Override
    public String topic() {
        return topic;
    }
}
