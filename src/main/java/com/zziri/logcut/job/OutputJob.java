package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class OutputJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 1;
    }

    @Override
    public String getName() {
        return "output";
    }

    @Override
    public List<String> run(List<String> lines) {
        try {
            Files.write(Paths.get(options.poll()).toAbsolutePath(), lines, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
