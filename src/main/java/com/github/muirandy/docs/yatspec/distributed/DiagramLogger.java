package com.github.muirandy.docs.yatspec.distributed;

public interface DiagramLogger {

    void log(Log log);

    Logs read();

    void markEnd(String sequence_diagram_id);

    Logs read(String logId);
}
