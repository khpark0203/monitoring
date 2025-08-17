package com.monitoring.kafka.config;

import com.monitoring.kafka.message.CpuMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    // Kafka 서버 주소 등 공통 설정
    private Map<String, Object> commonConsumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // 패키지를 신뢰하도록 설정해야 역직렬화가 가능합니다.
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return props;
    }

    @Bean
    public ConsumerFactory<String, CpuMessage> cpuMessageConsumerFactory() {
        Map<String, Object> props = commonConsumerConfig();
        // MessageA를 위한 JsonDeserializer 설정
        JsonDeserializer<CpuMessage> deserializer = new JsonDeserializer<>(CpuMessage.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CpuMessage> cpuMessageConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CpuMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cpuMessageConsumerFactory());
        return factory;
    }
}
