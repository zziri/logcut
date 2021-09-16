package com.zziri.logcut.service;

import com.zziri.logcut.job.Job;
import com.zziri.logcut.job.JobFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class PipelineService {
    private final JobFactory jobFactory;

    public Queue<Job> createPipeline(List<String> args) {
        int i = 0;
        Queue<Job> pipeline = new LinkedList<>();

        while (i < args.size()) {
            String name = args.get(i++);
            Job job = jobFactory.createJob(name);
            int n = job.getNumberOfOptions();
            while (n-- > 0) {
                job.addOption(args.get(i++));
            }
            pipeline.add(job);
        }

        return pipeline;
    }
}
