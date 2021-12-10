package dp.strategy;

import dp.Audio;
import dp.Bullet;
import dp.Group;
import dp.Tank;
import dp.factory.BaseTank;
import dp.factory.RectBullet;

/**
 * @author xt
 * @Desc
 */
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.getTf().factory.createBullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTf());

        if (tank.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
