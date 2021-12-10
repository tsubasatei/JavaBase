package dp.factory;

import dp.Audio;
import dp.ResourceMgr;
import dp.TankFrame;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class RectExplode extends BaseExplode {
    private int x;
    private int y;
    private TankFrame tf;
    private int step = 0;
    public static int WIDTH = ResourceMgr.getExplods()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplods()[0].getHeight();

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 15) {
            tf.getExplodes().remove(this);
        }
        g.setColor(color);
    }
}
