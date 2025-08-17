package com.monitoring.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.monitoring.node",
    "com.monitoring.kafka"
})
public class NodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeApplication.class, args);
    }
}