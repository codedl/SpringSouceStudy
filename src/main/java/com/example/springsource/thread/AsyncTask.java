package com.example.springsource.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    @Async(value = "originalThreadPool")
    public void processTask(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep " + i);
            }
        }catch (Exception e){

        }

    }
}
