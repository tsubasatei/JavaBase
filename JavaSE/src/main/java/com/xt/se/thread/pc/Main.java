package com.xt.se.thread.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {
        /*Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        Thread pro = new Thread(producer, "生产者");
        Thread con = new Thread(consumer, "消费者");
        pro.start();
        con.start();*/

        ArrayBlockingQueue<Product> blockingQueue = new ArrayBlockingQueue<>(5);
        Producer2 producer2 = new Producer2(blockingQueue);
        Consumer2 consumer2 = new Consumer2(blockingQueue);
        Thread pro2 = new Thread(producer2, "生产者");
        Thread con2 = new Thread(consumer2, "消费者");
        pro2.start();
        con2.start();
    }
}
