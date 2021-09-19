package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class InputJob extends Job {
    @Override
    public int getNumberOfOptions() {
        return 1;
    }

    @Override
    public String getName() {
        return "input";
    }

    @Override
    public List<String> run(List<String> lines) {
        List<String> ret = new ArrayList<>();
        try {
            ret = Files.readAllLines(Paths.get(options.get(0)).toAbsolutePath(), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
