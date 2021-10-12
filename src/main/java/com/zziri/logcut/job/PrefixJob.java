package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrefixJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 1;
    }

    @Override
    public String getName() {
        return "prefix";
    }

    @Override
    public List<String> run(List<String> lines) {
        String prefix = options.get(0);
        for (int i=0; i<lines.size(); i++) {
            lines.set(i, prefix + lines.get(i));
        }
        return lines;
    }
}
