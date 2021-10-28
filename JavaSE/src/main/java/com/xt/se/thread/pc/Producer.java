package com.xt.se.thread.pc;

/**
 * @author xt
 * @Desc
 */
public class Producer implements Runnable{
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                product.produce("百岁山", "矿泉水");
            } else{
                product.produce("稻香村", "月饼");
            }
        }
    }
}
