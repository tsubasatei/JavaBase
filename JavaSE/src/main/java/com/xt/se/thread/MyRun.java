package com.xt.se.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        MyRun r = new MyRun();
        Thread t = new Thread(r);
        t.start();
//        for (int i = 0; i < 5; i++) {
//            if (i == 3) {
//                try {
////                    t.join();
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(Thread.currentThread().getName() + " " + i);
//        }

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + " " + i + " 礼让一次");
            } else {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
