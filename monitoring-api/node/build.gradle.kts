project(":monitoring-api:node") {
    tasks {
        bootJar {
            enabled = true
        }

        jar {
            enabled = true
        }
    }

    
    dependencies {
        implementation("org.springframework.kafka:spring-kafka")
        implementation("org.apache.kafka:kafka-clients:3.6.0")

        implementation(project(":monitoring-domain"))
        implementation(project(":monitoring-infra:rdb"))
        implementation(project(":monitoring-infra:kafka"))
    }
}