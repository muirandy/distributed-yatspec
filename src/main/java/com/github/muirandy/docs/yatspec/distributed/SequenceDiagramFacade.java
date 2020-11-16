package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;

public class SequenceDiagramFacade {
    private DiagramLogger diagramLogger;

    public SequenceDiagramFacade(DiagramLogger diagramLogger) {
        this.diagramLogger = diagramLogger;
    }

    public void generate(TestState testState) {
        Logs logs = diagramLogger.read();
        logs.getLogs().forEach(l -> testState.log(l.getMessage(), l.getBody()));
    }

    public void log(Log log) {
        diagramLogger.log(log);
    }
}
