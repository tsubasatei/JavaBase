package com.xt.se.base;

/**
 * @author xt
 * @Desc
 */
public class DataType {
    public static void main(String[] args) {
        byte b = 127;
        System.out.println(b);

        short s = 32767;
        System.out.println(s);

        int i = Integer.MAX_VALUE;
        System.out.println(i);

        long l = Long.MAX_VALUE;
        System.out.println(l);

        float f = 3.141592653F;
        float f2 = 3.1415926534F;
        System.out.println(f);
        System.out.println(f2);
        System.out.println(f == f2);

        double d = 3.141592653;
        System.out.println(d);

        char c = 'c';
        System.out.println(c);
        System.out.println(c == 99);

        boolean bool = true;
        System.out.println(bool);



    }
}
