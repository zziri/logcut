package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplaceJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 2;
    }

    @Override
    public String getName() {
        return "replace";
    }

    @Override
    public List<String> run(List<String> lines) {
        String src = options.poll();
        String dst = options.poll();

        for (int i=0; i<lines.size(); i++) {
            lines.set(i, lines.get(i).replaceAll(src, dst));
        }

        return lines;
    }
}
