package com.zziri.logcut.job;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JobFactory {
    private final Map<String, Job> jobMap = new HashMap<>();

    JobFactory(List<Job> jobs) {
        jobs.forEach(job -> jobMap.put(job.getName(), job));
    }

    public Job createJob(String name) {
        return jobMap.get(name);
    }
}
