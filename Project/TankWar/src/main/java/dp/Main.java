package dp;

import dp.factory.BaseTank;
import dp.factory.RectTank;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {

        TankFrame tankFrame = new TankFrame();
        Integer enemyTankCount = PropertyMgr.getInt("enemyTankCount");
        for (int i = 0; i < enemyTankCount; i++) {
            tankFrame.engines.add(tankFrame.factory.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tankFrame));
        }
        new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        while (true) {
            // 暂停一会儿线程
            try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            tankFrame.repaint();
        }
    }
}
