package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 0;
    }

    @Override
    public String getName() {
        return "sort";
    }

    @Override
    public List<String> run(List<String> lines) {
        lines.sort(String::compareTo);
        return lines;
    }
}
