package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class This {
    String name;
    int age;

    public This() {
    }

    public This(String name) {
        this.name = name;
    }

    public This(String name, int age) {
        this(name);
        this.age = age;
    }

    public void test1() {
        System.out.println("test1");
    }

    public void test2(String name) {
        System.out.println("test2");
        this.test1();
        System.out.println(name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        This t = new This("张三", 18);
        t.test1();
        t.test2("李四");
    }
}
