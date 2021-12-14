package com.xt.dp.observer.v2;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc 面向对象傻等
 */
public class Main2 {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()) {
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("observing");
        }
    }
}
class Child {
    private boolean cry = false;
    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Wake up! Crying");
        cry = true;
    }
}
