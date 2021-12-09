package com.xt.dp.factorymethod;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {
        Movable movable = PlaneFactory.create();
        movable.go();

        movable = CarFactory.create();
        movable.go();
    }
}
