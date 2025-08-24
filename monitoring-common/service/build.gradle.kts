project(":monitoring-common:service") {
    tasks {
        bootJar {
            enabled = false
        }

        jar {
            enabled = true
        }
    }
}