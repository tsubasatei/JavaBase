package com.xt.dp.abstractfactory;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Food food = factory.createFood();
        food.eat();
        Weapon weapon = factory.createWeapon();
        weapon.play();
    }
}
