package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Car extends MotoVehicle {

    private String type;

    public Car(Integer no, String brand, String type) {
        super(no, brand);
        this.type = type;
    }

    @Override
    public int calRent(int day) {
        int rent = 0;
        switch(type){
            case "0":
                rent = 600 * day;
                break;
            case "1":
                rent = 500 * day;
                break;
            case "2":
                rent = 300 * day;
                break;
            default:
                System.out.println("暂无此种车型");
                break;
        }
        return rent;
    }
}
