package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistributeYatspecShould {
    private static final String MESSAGE = "Message";
    private static final Object BODY = "Body";

    private TestState testState = new TestState();

    @Mock
    private DiagramLogger diagramLogger;
    private SequenceDiagramFacade sequenceDiagramFacade;
    private Log log = new Log(MESSAGE, BODY);
    private Logs logs = new Logs();

    @BeforeEach
    void setUp() {
        sequenceDiagramFacade = new SequenceDiagramFacade(diagramLogger);
        lenient().when(diagramLogger.read()).thenReturn(logs);
    }

    @Test
    void generateNothingIfNoLogs() {
        sequenceDiagramFacade.generate(testState);

        assertThat(testState.getCapturedTypes()).isEmpty();
    }

    @Test
    void writeLogsToDiagramLogger() {
        sequenceDiagramFacade.log(log);

        verify(diagramLogger).log(log);
    }

    @Test
    void generateWhenDiagramLoggerReturnContent() {
        logs.add(log);

        sequenceDiagramFacade.generate(testState);

        assertThat(testState.getCapturedTypes().size()).isEqualTo(1);
    }
}
