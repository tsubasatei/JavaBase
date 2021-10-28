package com.xt.dp.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class Mgr05 {

    private static Mgr05 instance;

    private Mgr05() {

    }

    public static Mgr05 getInstance() {
        // 暂停一会儿线程
        if (instance == null) {
            synchronized (Mgr05.class) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Mgr05();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }

    }
}
