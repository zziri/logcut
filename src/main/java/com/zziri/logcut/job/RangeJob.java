package com.zziri.logcut.job;

import com.zziri.logcut.exception.NotAcceptableCommandException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class RangeJob extends Job {

    @Override
    public int getNumberOfOptions() {
        return 2;
    }

    @Override
    public String getName() {
        return "range";
    }

    @Override
    public List<String> run(List<String> lines) {
        String low = options.get(0);
        String high = options.get(1);

        if (low.compareTo(high) > 0) {
            log.error("Please check the order of parameters");
            throw new NotAcceptableCommandException();
        }

        log.info(String.format("cutting by range higher than %s, lower than %s", low, high));

        List<String> ret = new ArrayList<>();

        for (String line : lines) {
            if (line.compareTo(low) >= 0 && line.compareTo(high) <= 0) {
                ret.add(line);
            }
        }

        return ret;
    }
}
