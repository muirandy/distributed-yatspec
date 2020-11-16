package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DistributeYatspecShould {
    private static final String SOURCE = "Source";
    private static final String TARGET = "Target";
    private static final Object MESSAGE = "Message";

    private TestState testState = new TestState();

    @Mock
    private DiagramLogger diagramLogger;
    private SequenceDiagramFacade sequenceDiagramFacade;

    @BeforeEach
    void setUp() {
        sequenceDiagramFacade = new SequenceDiagramFacade(diagramLogger);
    }

    @Test
    void generateNothingIfNoLogs() {
        sequenceDiagramFacade.generate(testState);

        assertThat(testState.getCapturedTypes()).isEmpty();
    }

    @Test
    void writeLogsToDiagramLogger() {
        Log log = new Log(SOURCE, TARGET, MESSAGE);

        sequenceDiagramFacade.log(log);

        verify(diagramLogger).log(log);
    }
}
