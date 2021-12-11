package model;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class Main {
    public static void main(String[] args) {

        TankFrame tankFrame = new TankFrame();

        new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        while (true) {
            // 暂停一会儿线程
            try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            tankFrame.repaint();
        }
    }
}
