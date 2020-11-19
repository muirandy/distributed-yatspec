package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;

public class SequenceDiagramFacade {
    private static final String SEQUENCE_DIAGRAM_LOG_END_MARKER = "SEQUENCE_DIAGRAM_LOG_END_MARKER";

    private DiagramLogger diagramLogger;

    public SequenceDiagramFacade(DiagramLogger diagramLogger) {
        this.diagramLogger = diagramLogger;
    }

    public void generate(TestState testState) {
        Logs logs = diagramLogger.read();
        turnLogsIntoYatspecTestState(testState, logs);
    }

    public void log(Log log) {
        diagramLogger.log(log);
    }

    public void generate(TestState testState, String sequenceDiagramId) {
        diagramLogger.markEnd(sequenceDiagramId);
        Logs logs = diagramLogger.read(sequenceDiagramId);
        turnLogsIntoYatspecTestState(testState, logs);
    }

    private void turnLogsIntoYatspecTestState(TestState testState, Logs logs) {
        logs.getLogs().forEach(l -> testState.log(l.getMessage(), l.getBody()));
    }
}
