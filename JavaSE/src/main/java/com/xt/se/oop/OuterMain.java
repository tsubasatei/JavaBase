package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class OuterMain {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();

        Outer.Inner inner = new Outer().new Inner();
        inner.test();

    }
}
