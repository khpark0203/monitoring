package com.monitoring.domain.memory;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Builder
public class Memory {
    private long total;
    private long used;
}
