package com.github.muirandy.docs.yatspec.distributed;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private List<Log> logs = new ArrayList<>();

    public void add(Log log) {
        logs.add(log);
    }

    public List<Log> getLogs() {
        return logs;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
