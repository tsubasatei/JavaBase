package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Track extends MotoVehicle{

    private Integer weight;

    public Track(Integer no, String brand, Integer weight) {
        super(no, brand);
        this.weight = weight;
    }

    @Override
    public int calRent(int day) {
        return 50 * day * this.weight;
    }
}
