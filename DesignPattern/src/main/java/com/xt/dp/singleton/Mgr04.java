package com.xt.dp.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc 解决线程不安全问题，加synchronized锁，但效率降低
 */
public class Mgr04 {

    private static Mgr04 instance;

    private Mgr04() {

    }
    public static synchronized Mgr04 getInstance() {
        // 暂停一会儿线程
        if (instance == null) {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            instance = new Mgr04();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }

    }
}
