package com.example.springsource.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@Configuration
public class SpringThreadPool {
    @Autowired
    AsyncTask asyncTask;

    @RequestMapping("task")
    public String task(){
        asyncTask.processTask();
        return "processTask";
    }

    @Bean("taExecutor")
    public Executor taExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("synthetise-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        return executor;

    }

    @Bean("originalThreadPool")
    public Executor originalThreadPool() {
        int corePoolSize = 2;
        int maximumPoolSize = 3;
        long keepAliveTime = 1000;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        JavaThreadPool.DefaultThreadFactory threadFactory = new JavaThreadPool.DefaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        return new ThreadPoolExecutor(   corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                workQueue,
                threadFactory,
                handler);
    }

}
