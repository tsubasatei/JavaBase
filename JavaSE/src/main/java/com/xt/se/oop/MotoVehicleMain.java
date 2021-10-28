package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class MotoVehicleMain {
    public static void main(String[] args) {
//        Car car = new Car(1, "宝马", "1");
//        System.out.println(car.calRent(8));
//        Bus bus = new Bus(2, "金龙", 20);
//        System.out.println(bus.calRent(3));

        MotoVehicle[] motoVehicles = new MotoVehicle[5];
        motoVehicles[0] = new Car(1, "宝马", "1");
        motoVehicles[1] = new Car(1, "宝马", "1");
        motoVehicles[2] = new Car(2, "别克", "2");
        motoVehicles[3] = new Bus(3, "金龙", 34);
        motoVehicles[4] = new Track(4, "解放", 50);

        System.out.println(calTotalMoney(motoVehicles));


    }

    public static int calTotalMoney(MotoVehicle[] motoVehicles) {
        int rentMoney = 0;
        for (int i = 0; i < motoVehicles.length; i++) {
            rentMoney += motoVehicles[i].calRent(5);
        }
        return rentMoney;
    }

}
