package com.monitoring.memory;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class Memory {
    private long total;
    private long used;
}
