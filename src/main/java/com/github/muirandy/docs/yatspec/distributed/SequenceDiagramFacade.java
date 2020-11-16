package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;

public class SequenceDiagramFacade {
    private DiagramLogger diagramLogger;

    public SequenceDiagramFacade(DiagramLogger diagramLogger) {
        this.diagramLogger = diagramLogger;
    }

    public void generate(TestState testState) {
    }

    public void log(Log log) {
        diagramLogger.log(log);
    }
}
