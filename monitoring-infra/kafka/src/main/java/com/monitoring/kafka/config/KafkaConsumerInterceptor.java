package com.monitoring.kafka.config;

import com.monitoring.kafka.message.KafkaMessage;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RecordInterceptor;

public class KafkaConsumerInterceptor implements RecordInterceptor<String, KafkaMessage<Object>> {
    @Override
    public void success(ConsumerRecord<String, KafkaMessage<Object>> record, Consumer<String, KafkaMessage<Object>> consumer) {
        RecordInterceptor.super.success(record, consumer);
    }

    @Override
    public void failure(ConsumerRecord<String, KafkaMessage<Object>> record, Exception exception, Consumer<String, KafkaMessage<Object>> consumer) {
        RecordInterceptor.super.failure(record, exception, consumer);
    }

    @Override
    public void afterRecord(ConsumerRecord<String, KafkaMessage<Object>> record, Consumer<String, KafkaMessage<Object>> consumer) {
        RecordInterceptor.super.afterRecord(record, consumer);
    }

    @Override
    public ConsumerRecord<String, KafkaMessage<Object>> intercept(ConsumerRecord<String, KafkaMessage<Object>> record, Consumer<String, KafkaMessage<Object>> consumer) {
        return record;
    }
}
