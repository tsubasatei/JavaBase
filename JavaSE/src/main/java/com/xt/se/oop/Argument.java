package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Argument {
    public void test(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
        Argument argument = new Argument();
        int a = 10;
        int b = 20;
        System.out.println("a = " + a + ", b = " + b);
        argument.test(a, b);
        System.out.println("a = " + a + ", b = " + b);
    }
}
