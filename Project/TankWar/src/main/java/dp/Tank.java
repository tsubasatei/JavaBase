package dp;

import dp.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author xt
 * @Desc
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private Group group;
    public static final int SPEED = PropertyMgr.getInt("tankSpeed");
    private TankFrame tf;
    public static int WIDTH = ResourceMgr.getGoodTankD().getWidth();
    public static int HEIGHT = ResourceMgr.getGoodTankD().getHeight();
    private boolean moving = true;
    private boolean live = true;
    private Random random = new Random();
    private Rectangle rect = new Rectangle();
    private FireStrategy fireStrategy;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        String fireStrategyName = group == Group.GOOD ? PropertyMgr.getString("goodTankFireStrategy") : PropertyMgr.getString("badTankFireStrategy");
        try {
            Class<?> clazz = Class.forName(fireStrategyName);
            this.fireStrategy = (FireStrategy) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.engines.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getGoodTankL() : ResourceMgr.getBadTankL(), x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getGoodTankU() : ResourceMgr.getBadTankU(), x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getGoodTankR() : ResourceMgr.getBadTankR(), x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getGoodTankD() : ResourceMgr.getBadTankD(), x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }

        // 边界检测
        boundCheck();

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.dir = Dir.values()[random.nextInt(4)];
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        rect.x = x;
        rect.y = y;
    }

    private void boundCheck() {
        if (x < 2) x = 2;
        if (y < 28) y = 28;
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public TankFrame getTf() {
        return tf;
    }

    public Dir getDir() {
        return dir;
    }

    // 发射子弹
    public void fire() {
        /*int bX = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
        this.tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, tf));*/
        fireStrategy.fire(this);
    }

    public void die() {
        this.live = false;
    }

    public Rectangle getRect() {
        return rect;
    }
}
