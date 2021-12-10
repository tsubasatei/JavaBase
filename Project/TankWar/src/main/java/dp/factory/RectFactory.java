package dp.factory;

import dp.*;

/**
 * @author xt
 * @Desc
 */
public class RectFactory extends GameFactory {
    private static final RectFactory factory = new RectFactory();
    private RectFactory() {
    }
    public static RectFactory getInstance() {
        return factory;
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }
}
