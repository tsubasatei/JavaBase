package com.xt.dp.factorymethod;

/**
 * @author xt
 * @Desc
 */
public class PlaneFactory {
    public static Movable create() {
        return new Plane();
    }
}
