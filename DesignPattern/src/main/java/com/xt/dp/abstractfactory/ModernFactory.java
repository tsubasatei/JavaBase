package com.xt.dp.abstractfactory;

/**
 * @author xt
 * @Desc
 */
public class ModernFactory implements AbstractFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
