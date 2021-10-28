package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 * static变量 不能定义在方法里
 * static方法 不允许出现this，super
 */
public class Static {
    String name = "zhangsan";
    static int age = 10;

    public static void test() {
        System.out.println("static test");
    }

    public void test2() {
        System.out.println("test");
        test();
    }

    public static void main(String[] args) {
        Static s = new Static();
        System.out.println(s.name);
        System.out.println(s.age);

        System.out.println(Static.age);
        Static.test();
        s.test2();
    }
}
