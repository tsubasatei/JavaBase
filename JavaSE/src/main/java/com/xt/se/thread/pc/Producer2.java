package com.xt.se.thread.pc;

import java.util.concurrent.BlockingQueue;

/**
 * @author xt
 * @Desc
 */
public class Producer2 implements Runnable{
    private BlockingQueue<Product> blockingQueue;

    public Producer2(BlockingQueue<Product> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Product product = null;
            if (i % 2 == 0) {
                product = new Product("百岁山", "矿泉水");
            } else{
                product = new Product("稻香村", "月饼");
            }
            System.out.println(Thread.currentThread().getName() + " 生产了：" + product.getBrand() + "--" + product.getName());
            try {
                blockingQueue.put(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
