package v1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xt
 * @Desc
 */
public class ResourceMgr {
    static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    static BufferedImage badTankL, badTankU, badTankR, badTankD;
    static BufferedImage bulletL, bulletU, bulletR, bulletD;
    static BufferedImage[] explods = new BufferedImage[16];

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
}
