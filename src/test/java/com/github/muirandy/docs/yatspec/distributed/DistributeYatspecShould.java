package com.github.muirandy.docs.yatspec.distributed;

import com.github.muirandy.docs.living.api.DiagramLogger;
import com.github.muirandy.docs.living.api.Log;
import com.github.muirandy.docs.living.api.Logs;
import com.github.muirandy.docs.living.api.SequenceDiagramFacade;
import com.googlecode.yatspec.state.givenwhenthen.TestState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistributeYatspecShould {
    private static final String MESSAGE = "Message";
    private static final String BODY = "Body";
    private static final String SEQUENCE_DIAGRAM_LOG_END_MARKER = "SEQUENCE_DIAGRAM_LOG_END_MARKER";

    private TestState testState = new TestState();
    private String SEQUENCE_DIAGRAM_ID = UUID.randomUUID().toString();

    @Mock
    private DiagramLogger diagramLogger;
    private SequenceDiagramFacade sequenceDiagramFacade;
    private Log log = new Log(MESSAGE, BODY);
    private Logs logs = new Logs();

    @BeforeEach
    void setUp() {
        sequenceDiagramFacade = new YatspecSequenceDiagramFacade(diagramLogger, testState);
        lenient().when(diagramLogger.read()).thenReturn(logs);
    }

    @Test
    void generateNothingIfNoLogs() {
        sequenceDiagramFacade.generate();

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

        sequenceDiagramFacade.generate();

        assertThat(testState.getCapturedTypes().size()).isEqualTo(1);
    }

    @Test
    void logEndMarkerIsWrittenBeforeReadingSequenceDiagramLogs() {
        when(diagramLogger.read(SEQUENCE_DIAGRAM_ID)).thenReturn(logs);

        sequenceDiagramFacade.generate(SEQUENCE_DIAGRAM_ID);

        InOrder inOrder = inOrder(diagramLogger);
        inOrder.verify(diagramLogger).markEnd(SEQUENCE_DIAGRAM_ID);
        inOrder.verify(diagramLogger).read(SEQUENCE_DIAGRAM_ID);
    }
}
