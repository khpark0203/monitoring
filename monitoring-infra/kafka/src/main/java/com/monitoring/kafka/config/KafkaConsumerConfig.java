package com.monitoring.kafka.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.monitoring.kafka.message.CpuMessage;
import com.monitoring.kafka.message.KafkaMessage;
import com.monitoring.kafka.properties.KafkaConsumerProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaConsumerProperties kafkaConsumerProperties;

    public Map<String, Object> props() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.bootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerProperties.groupId());
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.monitoring.kafka.message");


        return props;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaMessage<CpuMessage>> cpuMessageFactory() {
        Map<String, Object> props = props();
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new TypeReference<KafkaMessage<CpuMessage>>() {});

        DefaultKafkaConsumerFactory<String, KafkaMessage<CpuMessage>> defaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(
            props,
            new StringDeserializer(),
            new JsonDeserializer<>(new TypeReference<KafkaMessage<CpuMessage>>() {
            })
        );

        ConcurrentKafkaListenerContainerFactory<String, KafkaMessage<CpuMessage>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(defaultKafkaConsumerFactory);
        return factory;
    }

}
