package com.example.springsource.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AsyncThread {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();

        ConcurrentHashMap map = new ConcurrentHashMap(18);
        map.put("java","hello");

        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("线程:"+integer.incrementAndGet());
                }finally {
                    lock.unlock();
                }
            }).start();
        }

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    A.join();
                    System.out.println("拿出牛奶");
                } catch (Exception e) {

                }
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    B.join();
                    System.out.println("关上冰箱");
                } catch (Exception e) {

                }
            }
        });

        A.start();
        B.start();
        C.start();
    }

}
