package com.xt.se.thread.pc;

/**
 * @author xt
 * @Desc
 */
public class Consumer implements Runnable{
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            product.consume();
        }
    }
}
