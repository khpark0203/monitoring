rootProject.name = "server"

include(":monitoring-api:node")
include(":monitoring-common:service")

include(":monitoring-infra:rdb")
include(":monitoring-infra:kafka")

include(":monitoring-domain")