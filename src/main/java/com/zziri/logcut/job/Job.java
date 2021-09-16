package com.zziri.logcut.job;

import java.util.ArrayList;
import java.util.List;

public abstract class Job {
    protected List<String> options;
    public abstract int getNumberOfOptions();
    public abstract String getName();
    public abstract List<String> run(List<String> lines);

    public void addOption(String option) {
        if (options == null)
            options = new ArrayList<>();
        options.add(option);
    }
}
