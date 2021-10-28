package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public interface C extends Lock, DoorBell{

    default void test() {
        System.out.println("test");
    }
}
