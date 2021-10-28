package com.xt.tank;

/**
 * @author xt
 * @Desc
 */
public class DefaultFireStrategy implements FireStrategy {
    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    private DefaultFireStrategy() {

    }
    @Override
    public void fire(Tank tank) {
        new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2,
                tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2,
                tank.getDir(), tank.getGroup(), tank.getFrame());
        if (tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public static DefaultFireStrategy getInstance() {
        return INSTANCE;
    }
}
