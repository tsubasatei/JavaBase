package com.xt.se.thread.pc;

import java.util.concurrent.BlockingQueue;

/**
 * @author xt
 * @Desc
 */
public class Consumer2 implements Runnable{
    private BlockingQueue<Product> blockingQueue;

    public Consumer2(BlockingQueue<Product> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Product pro = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " 消费了：" + pro.getBrand() + "--" + pro.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
