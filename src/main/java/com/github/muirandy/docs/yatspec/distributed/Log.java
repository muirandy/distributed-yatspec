package com.github.muirandy.docs.yatspec.distributed;

public class Log {
    private final String source;
    private final String target;
    private final Object message;

    public Log(String source, String target, Object message) {
        this.source = source;
        this.target = target;
        this.message = message;
    }
}
