package com.xt.se.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class Ticket {
    private Integer ticket = 5;

    public void buyTicket() {
        for (int i = 0; i < 100; i++) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " " + ticket--);
                }
            }
        }

    }

    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(() -> t.buyTicket(), "t1");
        Thread t2 = new Thread(() -> t.buyTicket(), "t2");
        t1.start();
        t2.start();
    }
}
