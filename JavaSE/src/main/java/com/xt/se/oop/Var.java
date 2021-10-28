package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Var {
    static int age = 20;

    public void test() {
        System.out.println(age);
        age = 10;
        System.out.println(age);
        int age = 30;
        System.out.println(age);
    }
    public void show() {
        int a = 10;
        String name = "zhangsan";
        System.out.println(age);
    }

    public static void main(String[] args) {
        System.out.println(age);
        new Var().test();
        System.out.println(age);
    }
}
