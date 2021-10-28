package com.xt.se.thread.pool;

import java.util.concurrent.*;

/**
 * @author xt
 * @Desc
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue(5));
        pool.execute(() -> System.out.println(Math.random()));
        pool.shutdown();
    }
}
