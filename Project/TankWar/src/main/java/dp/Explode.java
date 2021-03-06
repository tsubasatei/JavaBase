package dp;

import dp.factory.BaseExplode;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class Explode extends BaseExplode {
    private int x;
    private int y;
    private TankFrame tf;
    private int step = 0;
    public static int WIDTH = ResourceMgr.getExplods()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplods()[0].getHeight();

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.getExplods()[step++], x, y, null);
        if (step >= ResourceMgr.getExplods().length) {
            tf.explodes.remove(this);
        }
    }
}
