package model;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class Wall extends GameObject{
    private int w, h;
    private Rectangle rect = new Rectangle();

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        GameModel.getInstance().add(this);

        rect.x = x;
        rect.y = y;
        rect.width = w;
        rect.height = h;
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(color);
    }

    public Rectangle getRect() {
        return rect;
    }
}
