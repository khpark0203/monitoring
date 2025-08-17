project(":monitoring-domain") {
    tasks {
        bootJar {
            enabled = false
        }

        jar {
            enabled = true
        }
    }
}