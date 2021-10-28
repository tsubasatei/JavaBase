package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Bus extends MotoVehicle {

    private int seatCount;

    public Bus(Integer no, String brand, int seatCount) {
        super(no, brand);
        this.seatCount = seatCount;
    }

    @Override
    public int calRent(int day) {
        if (seatCount <= 16) {
            return 800 * day;
        } else {
            return 1500 * day;
        }
    }
}
