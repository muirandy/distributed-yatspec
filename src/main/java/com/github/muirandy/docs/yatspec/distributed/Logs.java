package com.github.muirandy.docs.yatspec.distributed;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private List<Log> logs = new ArrayList<>();

    public void add(Log log) {
        logs.add(log);
    }

    public List<Log> getLogs() {
        return logs;
    }
}
