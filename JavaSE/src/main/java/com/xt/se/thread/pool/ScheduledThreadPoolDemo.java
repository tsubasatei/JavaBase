package com.xt.se.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(() -> {
            System.out.println("延时3秒执行");
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
