package com.zziri.logcut.service;

import com.zziri.logcut.job.Job;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Queue;

@Service
@RequiredArgsConstructor
@Slf4j
public class StarterService {
    private final ArgumentService argumentService;
    private final PipelineService pipelineService;
    private final BatchService batchService;

    @PostConstruct
    private void postConstruct() {
        try {
            List<String> args = argumentService.getArguments();
            Queue<Job> pipeline = pipelineService.createPipeline(args);
            batchService.batch(pipeline);
        } catch (Exception e) {
            log.error("Error Occurred", e);
        }
    }
}
