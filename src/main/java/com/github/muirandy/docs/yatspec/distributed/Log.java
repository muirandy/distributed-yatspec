package com.github.muirandy.docs.yatspec.distributed;

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
}
