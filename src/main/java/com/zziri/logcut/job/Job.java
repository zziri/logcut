package com.zziri.logcut.job;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Job {
    protected Queue<String> options;
    public abstract int getNumberOfOptions();
    public abstract String getName();
    public abstract List<String> run(List<String> lines);

    public void addOption(String option) {
        if (options == null)
            options = new LinkedList<>();
        options.add(option);
    }
}
