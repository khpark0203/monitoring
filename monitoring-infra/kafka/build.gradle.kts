project(":monitoring-infra:kafka") {
    tasks {
        bootJar {
            enabled = false
        }

        jar {
            enabled = true
        }
    }

    dependencies {
        implementation("org.apache.kafka:kafka-clients:3.6.0")
        implementation("org.springframework.kafka:spring-kafka")
    }
}