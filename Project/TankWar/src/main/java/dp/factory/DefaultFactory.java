package dp.factory;

import dp.*;

/**
 * @author xt
 * @Desc
 */
public class DefaultFactory extends GameFactory {
    private static final DefaultFactory factory = new DefaultFactory();
    private DefaultFactory() {
    }
    public static DefaultFactory getInstance() {
        return factory;
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }
}
