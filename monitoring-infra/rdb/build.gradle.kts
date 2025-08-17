project(":monitoring-infra:rdb") {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.hibernate:hibernate-spatial:6.4.4.Final")
        implementation("org.mariadb.jdbc:mariadb-java-client")

        annotationProcessor("jakarta.persistence:jakarta.persistence-api")
        annotationProcessor("jakarta.annotation:jakarta.annotation-api")

        runtimeOnly("com.h2database:h2")
    }
}