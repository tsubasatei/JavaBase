package dp.factory;

import dp.Dir;
import dp.Group;
import dp.TankFrame;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public abstract class BaseTank {
    private int x;
    private int y;
    private Dir dir;
    private Group group;
    private TankFrame tf;
    private boolean moving = true;
    private boolean live = true;
    private Rectangle rect = new Rectangle();
    public abstract void paint(Graphics g);
    public abstract void fire();
    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void die() {
        this.live = false;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }

    public Group getGroup() {
        return group;
    }

    public TankFrame getTf() {
        return tf;
    }

    public Rectangle getRect() {
        return rect;
    }
}
