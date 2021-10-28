package com.xt.se.basic.base;

public class Test01_Var {
    public static void main(String[] args) {
        int num1 = 12;
        System.out.println(num1);
        int num2 = 012; // 八进制
        System.out.println(num2);
        int num3 = 0X12; // 十六进制
        System.out.println(num3);
        int num4 = 0b10; // 二进制
        System.out.println(num4);

        byte b = 127;
        System.out.println(b);

        short s = 30000;
        System.out.println(s);

        int i = 1234567890;
        System.out.println(i);

        long num5 = 12345678900L;
        System.out.println(num5);

        long num6 = 12;
        System.out.println(num6);

        System.out.println("-----------------");
        double d1 = 3.14;
        System.out.println(d1);
        double d2 = 314E-2;
        System.out.println(d2);
        System.out.println(d1 == d2); // true

        float f = 0.3F;
        System.out.println(f);
        double d3 = 0.3;
        System.out.println(d3);
        System.out.println(f == d3); // false

        float f1 = 3.141592653F;
        System.out.println(f1);
        double d4 = 3.141592653;
        System.out.println(d4);

        System.out.println("------------");

        // 看到的是字面值，而非码值，运算时用码值计算
        char ch = ' '; // 单引号括起来的单个字符
        System.out.println(ch);

    }
}
