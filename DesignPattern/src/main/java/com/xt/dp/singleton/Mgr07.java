package com.xt.dp.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，实现懒加载
 */
public class Mgr07 {

    private Mgr07() {

    }
    public static Mgr07 getInstance() {
        return Inner.instance;

    }

    private static class Inner {
        private static Mgr07 instance = new Mgr07();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            new Thread(() -> System.out.println(Mgr07.getInstance().hashCode())).start();
        }

    }
}
