package model;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract int getWidth();
    public abstract int getHeight();
}
