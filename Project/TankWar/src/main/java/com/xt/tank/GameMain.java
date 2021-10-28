package com.xt.tank;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class GameMain {
    public static void main(String[] args) {
//        new AudioPlayer("audio/bgm.mp3");
        new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        TankFrame tankFrame = new TankFrame();
        int enemyTankCount = Integer.parseInt(PropertyMgr.getInstance().get("enemyTankCount"));
        for (int i = 0; i < enemyTankCount; i++) {
            tankFrame.getEnemyTanks().add(new Tank(50 + i * 80, 100, Dir.DOWN, Group.BAD, tankFrame));
        }
        while (true) {
            // 暂停一会儿线程
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankFrame.repaint();
        }
    }
}
