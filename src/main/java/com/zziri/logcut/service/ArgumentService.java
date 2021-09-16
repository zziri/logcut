package com.zziri.logcut.service;

import com.zziri.logcut.exception.NotAcceptableCommandException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArgumentService {
    private final ApplicationArguments applicationArguments;

    public List<String> getArguments() {
        String[] args = applicationArguments.getSourceArgs();
        try {
            if (args.length < 3) {
                throw new NotAcceptableCommandException();
            }
        } catch (NotAcceptableCommandException e) {
            System.out.println(e.getMessage());
        }

        List<String> ret = new ArrayList<>();
        String inputFile = args[0];
        String outputFile = args[1];

        ret.add("input");
        ret.add(inputFile);
        ret.addAll(Arrays.asList(args).subList(2, args.length));
        ret.add("output");
        ret.add(outputFile);

        return ret;
    }
}
