package model;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class Explode extends GameObject {
    private int step = 0;
    public static int WIDTH = ResourceMgr.getExplods()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplods()[0].getHeight();

    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
        this.gameModel.objects.add(this);
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.getExplods()[step++], this.x, this.y, null);
        if (step >= ResourceMgr.getExplods().length) {
            this.gameModel.objects.remove(this);
        }
    }
}
