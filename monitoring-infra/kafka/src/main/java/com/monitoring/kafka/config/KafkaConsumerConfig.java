package com.monitoring.kafka.config;

import com.monitoring.kafka.message.KafkaMessage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public RecordInterceptor<String, KafkaMessage<Object>> kafkaMessageRecordInterceptor() {
        return new KafkaConsumerInterceptor();
    }

    @Bean
    public static BeanPostProcessor recordInterceptorApplier(
        RecordInterceptor<?, ?> recordInterceptor
    ) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof ConcurrentKafkaListenerContainerFactory<?, ?> factory) {
                    factory.setRecordInterceptor((RecordInterceptor) recordInterceptor);
                }

                return bean;
            }
        };
    }
}
