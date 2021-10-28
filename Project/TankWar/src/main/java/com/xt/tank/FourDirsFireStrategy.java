package com.xt.tank;

/**
 * @author xt
 * @Desc
 */
public class FourDirsFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2,
                    tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2,
                    dir, tank.getGroup(), tank.getFrame());
        }
        if (tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
