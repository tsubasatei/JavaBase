package com.xt.dp.abstractfactory;

/**
 * @author xt
 * @Desc
 */
public interface AbstractFactory {
    Vehicle createVehicle();
    Food createFood();
    Weapon createWeapon();
}
