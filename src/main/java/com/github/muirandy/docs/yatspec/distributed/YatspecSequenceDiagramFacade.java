package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;

public class YatspecSequenceDiagramFacade implements SequenceDiagramFacade {
    private DiagramLogger diagramLogger;
    private TestState testState;

    public YatspecSequenceDiagramFacade(DiagramLogger diagramLogger, TestState testState) {
        this.diagramLogger = diagramLogger;
        this.testState = testState;
    }

    @Override
    public void generate() {
        Logs logs = diagramLogger.read();
        turnLogsIntoYatspecTestState(testState, logs);
    }

    @Override
    public void log(Log log) {
        diagramLogger.log(log);
    }

    @Override
    public void generate(String sequenceDiagramId) {
        diagramLogger.markEnd(sequenceDiagramId);
        Logs logs = diagramLogger.read(sequenceDiagramId);
        turnLogsIntoYatspecTestState(testState, logs);
    }

    private void turnLogsIntoYatspecTestState(TestState testState, Logs logs) {
        logs.getLogs().forEach(l -> testState.log(l.getMessage(), l.getBody()));
    }
}
