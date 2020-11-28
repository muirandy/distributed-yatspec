package com.github.muirandy.docs.yatspec.distributed;

import com.github.muirandy.docs.living.api.DiagramLogger;
import com.github.muirandy.docs.living.api.Log;
import com.github.muirandy.docs.living.api.Logs;

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
