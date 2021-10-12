package com.zziri.logcut.listener;

import com.zziri.logcut.job.Job;
import com.zziri.logcut.service.ArgumentService;
import com.zziri.logcut.service.BatchService;
import com.zziri.logcut.service.PipelineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;

@Component
@RequiredArgsConstructor
@Slf4j
public class LogcutAppListener implements ApplicationListener<ContextRefreshedEvent> {
    private final ArgumentService argumentService;
    private final PipelineService pipelineService;
    private final BatchService batchService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            List<String> args = argumentService.getArguments();
            Queue<Job> pipeline = pipelineService.createPipeline(args);
            batchService.batch(pipeline);
        } catch (Exception e) {
            log.error("Error Occurred", e);
        }
    }
}

