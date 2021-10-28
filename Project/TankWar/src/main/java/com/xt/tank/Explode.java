package com.xt.tank;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class Explode {
    private int x;
    private int y;
    public static int EXPLODE_WIDTH = ResourceMgr.getExplodes()[0].getWidth();
    public static int EXPLODE_HEIGHT = ResourceMgr.getExplodes()[0].getHeight();
    private boolean isLive = true;
    private int step = 0;
    private TankFrame frame;

    public Explode() {
    }

    public Explode(int x, int y, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;
//        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.getExplodes()[step++], x, y, null);
        if (step >= ResourceMgr.getExplodes().length) {
            this.frame.getExplodes().remove(this);
        }

    }

}
