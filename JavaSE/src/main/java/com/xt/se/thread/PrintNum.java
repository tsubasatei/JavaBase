package com.xt.se.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class PrintNum implements Runnable{


    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "========" + i);
            // 暂停一会儿线程
            try { TimeUnit.MILLISECONDS.sleep(1050); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintNum()).start();
        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "========" + i);
            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        }
    }
}
