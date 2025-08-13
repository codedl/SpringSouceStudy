package com.example.springsource.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaThreadPool {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 3;
        long keepAliveTime = 1000;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        DefaultThreadFactory threadFactory = new DefaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(   corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                workQueue,
                threadFactory,
                handler);
        int reject = 0;
        /*for (int i = 0; i < 25; i ++){
            try {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.currentThread().sleep(120000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("执行完毕");
                    }
                });
                System.out.println( "线程池中线程数目："+executor.getPoolSize()+
                        "，队列中等待执行的任务数目："+ executor.getQueue().size()+
                        "，已执行完别的任务数目："+executor.getCompletedTaskCount());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("线程处理失败次数"+(++reject));
            }
        }*/
        for (int i = 0; i < 25; i ++){
            try {
                Future future = executor.submit(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        return "helloworld";
                    }
                });
                Object o = future.get();
                System.out.println(o.toString());
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        executor.shutdown();
    }

    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
