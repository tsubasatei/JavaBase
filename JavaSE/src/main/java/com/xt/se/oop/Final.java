package com.xt.se.oop;

/**
 * @author xt
 * @Desc 不能被继承
 */
public final class Final {
    public static final int age = 10;

    // 不能被重写
    public final void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
    }
}
