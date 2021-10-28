package com.xt.se.common;

/**
 * @author xt
 * @Desc
 */
public class IntegerDemo {
    public static void main(String[] args) {
        /*int a = 10;
        Integer i = new Integer(a);
        Integer i2 = Integer.valueOf(a);
        System.out.println(a == i);
        System.out.println(a == i2);
        int i3 = i2.intValue();
        System.out.println(a == i3);

        Float f = new Float(3.14);
        Double d = new Double(3.14);*/

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false

        Double d1 = 1.0;
        Double d2 = 1.0;
        Double d3 = 1.0;
        Double d4 = 1.0;
        System.out.println(d1 == d2); // false
        System.out.println(d3 == d4); // false

    }
}
