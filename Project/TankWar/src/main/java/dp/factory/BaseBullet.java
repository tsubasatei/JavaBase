package dp.factory;

import dp.Tank;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWith(BaseTank tank);
}
