package com.xt.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xt
 * @Desc
 */
public class ResourceMgr {
    private static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    private static BufferedImage badTankL, badTankU, badTankR, badTankD;
    private static BufferedImage bulletL, bulletU, bulletR, bulletD;
    private static BufferedImage[] explodes = new BufferedImage[16];

    private static final ResourceMgr resourceMgr = new ResourceMgr();
    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResource("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResource("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResource("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

            for (int i = 0; i < 16; i++) {
                InputStream is;
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResource("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ResourceMgr() {
    }

    public static ResourceMgr getInstance() {
        return resourceMgr;
    }

    public static BufferedImage getGoodTankL() {
        return goodTankL;
    }

    public static BufferedImage getGoodTankU() {
        return goodTankU;
    }

    public static BufferedImage getGoodTankR() {
        return goodTankR;
    }

    public static BufferedImage getGoodTankD() {
        return goodTankD;
    }

    public static BufferedImage getBulletL() {
        return bulletL;
    }

    public static BufferedImage getBulletU() {
        return bulletU;
    }

    public static BufferedImage getBulletR() {
        return bulletR;
    }

    public static BufferedImage getBulletD() {
        return bulletD;
    }

    public static BufferedImage getBadTankL() {
        return badTankL;
    }

    public static BufferedImage getBadTankU() {
        return badTankU;
    }

    public static BufferedImage getBadTankR() {
        return badTankR;
    }

    public static BufferedImage getBadTankD() {
        return badTankD;
    }

    public static void main(String[] args) {
        System.out.println(goodTankU.getWidth());
        System.out.println(goodTankU.getHeight());
    }

    public static BufferedImage[] getExplodes() {
        return explodes;
    }
}
