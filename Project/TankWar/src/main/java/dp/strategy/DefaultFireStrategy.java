package dp.strategy;

import dp.Bullet;
import dp.Tank;

/**
 * @author xt
 * @Desc
 */
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.getTf().getBullets().add(new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTf()));
    }
}
