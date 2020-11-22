package com.github.muirandy.docs.yatspec.distributed;

public class NoOpDiagramLogger implements DiagramLogger {
    @Override
    public void log(Log log) {
    }

    @Override
    public Logs read() {
        return new Logs();
    }

    @Override
    public void markEnd(String sequence_diagram_id) {
    }

    @Override
    public Logs read(String logId) {
        return new Logs();
    }
}
