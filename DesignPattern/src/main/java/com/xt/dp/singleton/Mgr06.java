package com.xt.dp.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc 多线程错误
 */
public class Mgr06 {

    private static volatile Mgr06 instance;

    private Mgr06() {

    }
    public static Mgr06 getInstance() {
        if (instance == null) {
            synchronized (Mgr06.class) {
                // 暂停一会儿线程
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                if (instance == null) instance = new Mgr06();
            }
        }
        return instance;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Mgr06.getInstance().hashCode())).start();
        }

    }
}
