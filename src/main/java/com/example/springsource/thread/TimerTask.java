package com.example.springsource.thread;

import org.assertj.core.util.DateUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
@EnableScheduling
public class TimerTask {

    @Scheduled(fixedDelay = 5000)
    public void timer(){
        System.out.println(DateUtil.now());
    }
}
