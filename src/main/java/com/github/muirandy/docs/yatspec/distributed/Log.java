package com.github.muirandy.docs.yatspec.distributed;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Log {
    private final String message;
    private final Object body;

    public Log(String message, Object body) {
        this.message = message;
        this.body = body;
    }


    public String getMessage() {
        return message;
    }

    public Object getBody() {
        return body;
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
