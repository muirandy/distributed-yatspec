package com.github.muirandy.docs.yatspec.distributed;

import com.googlecode.yatspec.state.givenwhenthen.TestState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistributeYatspecShould {
    private TestState testState = new TestState();

    @Test
    void generateNothingIfNoLogs() {
        SequenceDiagramFacade sequenceDiagramFacade = new SequenceDiagramFacade();

        sequenceDiagramFacade.generate(testState);

        assertThat(testState.getCapturedTypes()).isEmpty();
    }
}
