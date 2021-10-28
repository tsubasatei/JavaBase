package com.xt.dp.abstractfactory;

/**
 * @author xt
 * @Desc
 */
public class MagicFactory implements AbstractFactory{
    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
