package com.xt.se.base;

/**
 * @author xt
 * @Desc
 */
public class Operator {
    public static void main(String[] args) {
        // 算术运算符
        int a = 1;
        int b = 2;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(a++); // 1
        System.out.println(++a); // 3
        System.out.println(a--); // 3
        System.out.println(--a); // 1
        System.out.println(++b+b++); // 6

        // 赋值运算符
        int c = 1;
        c += 2;
        System.out.println(c);

        byte d = 10;
//        d = d + 1; //  类型转换错误
        d += 1;

        // 关系运算符
        System.out.println(1 > 2);
        System.out.println(1 < 2);
        System.out.println(1 >= 2);
        System.out.println(1 <= 2);
        System.out.println(1 == 2);
        System.out.println(1 != 2);

        // 逻辑运算符
        // 短路与&&、短路||
        System.out.println(3 > 5 && 3 < 4);
        System.out.println(3 > 5 || 3 < 4);
        System.out.println(!(3 > 5));
        System.out.println(!true);

        // 位运算符
        System.out.println(4 & 5);
        System.out.println(4 | 5);
        System.out.println(4 ^ 5);
        System.out.println(~4);
        System.out.println(2 << 3);
        System.out.println(16 >> 2);
        System.out.println(16 >>> 2);

        // 条件运算符 三目运算符
        System.out.println(3 > 2 ? 3 : 2);
        System.out.println(true ? false : true ? false : true);

        // 类型转换
        // byte/short/char -> int -> long -> float -> double
        byte bb = 10;
        int aa = 200;
        byte cc = (byte) (aa + bb);
        System.out.println(cc); // -46 高位1，负数
    }
}
