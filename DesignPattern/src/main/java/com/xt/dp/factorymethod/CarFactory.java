package com.xt.dp.factorymethod;

/**
 * @author xt
 * @Desc
 */
public class CarFactory {
    public static Movable create() {
        return new Car();
    }
}
