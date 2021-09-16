package com.zziri.logcut.service;

import com.zziri.logcut.job.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;

@Component
public class BatchService {
    public void batch(Queue<Job> pipeline) {
        List<String> input = null;
        while (!pipeline.isEmpty()) {
            Job job = pipeline.poll();
            input = job.run(input);
        }
    }
}
