package com.zziri.logcut.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class LogcutAppListener implements ApplicationListener {
    private final ApplicationArguments applicationArguments;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        String[] args = applicationArguments.getSourceArgs();
        System.out.println(Arrays.toString(args));
    }
}

