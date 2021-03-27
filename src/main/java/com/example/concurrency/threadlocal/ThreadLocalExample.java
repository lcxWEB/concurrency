package com.example.concurrency.threadlocal;

/**
 * @author: lichunxia
 * @create: 2021-03-21 21:03
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }

}
