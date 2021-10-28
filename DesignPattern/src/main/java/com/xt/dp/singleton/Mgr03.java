package com.xt.dp.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc 多线程下有问题
 */
public class Mgr03 {

    private static Mgr03 instance;

    private Mgr03() {

    }
    public static Mgr03 getInstance() {
        // 暂停一会儿线程
        if (instance == null) {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            instance = new Mgr03();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }

    }
}
