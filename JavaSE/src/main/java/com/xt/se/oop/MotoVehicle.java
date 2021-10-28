package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public abstract class MotoVehicle {

    private Integer no;
    private String brand;
    public abstract int calRent(int day);

    public MotoVehicle(Integer no, String brand) {
        this.no = no;
        this.brand = brand;
    }
}
