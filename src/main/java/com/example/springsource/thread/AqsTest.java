package com.example.springsource.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
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

    }
}
