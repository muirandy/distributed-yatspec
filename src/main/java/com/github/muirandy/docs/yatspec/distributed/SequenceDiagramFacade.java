package com.github.muirandy.docs.yatspec.distributed;

public interface SequenceDiagramFacade {
    void generate();

    void log(Log log);

    void generate(String sequenceDiagramId);
}
