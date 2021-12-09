package dp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class ResourceMgr {
    private static final ResourceMgr resourceMgr = new ResourceMgr();
    private ResourceMgr() {

    }
    private static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    private static BufferedImage badTankL, badTankU, badTankR, badTankD;
    private static BufferedImage bulletL, bulletU, bulletR, bulletD;
    private static BufferedImage[] explods = new BufferedImage[16];

    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(goodTankU, -90);
            badTankR = ImageUtil.rotateImage(goodTankU, 90);
            badTankD = ImageUtil.rotateImage(goodTankU, 180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

            for (int i = 0; i < 16; i++) {
                explods[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ResourceMgr getInstance() {
        return resourceMgr;
    }

    public static BufferedImage getGoodTankL() {
        return goodTankL;
    }

    public static void setGoodTankL(BufferedImage goodTankL) {
        ResourceMgr.goodTankL = goodTankL;
    }

    public static BufferedImage getGoodTankU() {
        return goodTankU;
    }

    public static void setGoodTankU(BufferedImage goodTankU) {
        ResourceMgr.goodTankU = goodTankU;
    }

    public static BufferedImage getGoodTankR() {
        return goodTankR;
    }

    public static void setGoodTankR(BufferedImage goodTankR) {
        ResourceMgr.goodTankR = goodTankR;
    }

    public static BufferedImage getGoodTankD() {
        return goodTankD;
    }

    public static void setGoodTankD(BufferedImage goodTankD) {
        ResourceMgr.goodTankD = goodTankD;
    }

    public static BufferedImage getBadTankL() {
        return badTankL;
    }

    public static void setBadTankL(BufferedImage badTankL) {
        ResourceMgr.badTankL = badTankL;
    }

    public static BufferedImage getBadTankU() {
        return badTankU;
    }

    public static void setBadTankU(BufferedImage badTankU) {
        ResourceMgr.badTankU = badTankU;
    }

    public static BufferedImage getBadTankR() {
        return badTankR;
    }

    public static void setBadTankR(BufferedImage badTankR) {
        ResourceMgr.badTankR = badTankR;
    }

    public static BufferedImage getBadTankD() {
        return badTankD;
    }

    public static void setBadTankD(BufferedImage badTankD) {
        ResourceMgr.badTankD = badTankD;
    }

    public static BufferedImage getBulletL() {
        return bulletL;
    }

    public static void setBulletL(BufferedImage bulletL) {
        ResourceMgr.bulletL = bulletL;
    }

    public static BufferedImage getBulletU() {
        return bulletU;
    }

    public static void setBulletU(BufferedImage bulletU) {
        ResourceMgr.bulletU = bulletU;
    }

    public static BufferedImage getBulletR() {
        return bulletR;
    }

    public static void setBulletR(BufferedImage bulletR) {
        ResourceMgr.bulletR = bulletR;
    }

    public static BufferedImage getBulletD() {
        return bulletD;
    }

    public static void setBulletD(BufferedImage bulletD) {
        ResourceMgr.bulletD = bulletD;
    }

    public static BufferedImage[] getExplods() {
        return explods;
    }

    public static void setExplods(BufferedImage[] explods) {
        ResourceMgr.explods = explods;
    }
}
