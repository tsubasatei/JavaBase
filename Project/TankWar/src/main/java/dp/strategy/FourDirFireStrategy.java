package dp.strategy;

import dp.*;
import dp.factory.BaseTank;

/**
 * @author xt
 * @Desc
 */
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (Dir dir : Dir.values()) {
            tank.getTf().factory.createBullet(bX, bY, dir, tank.getGroup(), tank.getTf());
        }
        if (tank.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
