package com.example.springsource.thread;

public class ThreadLocalTest {
    public static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    local.set("hello" + Thread.currentThread());
                    System.out.println(local.get());
                }
            }).start();
        }
    }
}
