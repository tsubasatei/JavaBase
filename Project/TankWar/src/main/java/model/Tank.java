package model;

import model.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author xt
 * @Desc
 */
public class Tank extends GameObject{
    private Dir dir;
    private Group group;
    public static final int SPEED = PropertyMgr.getInt("tankSpeed");
    public static int WIDTH = ResourceMgr.getGoodTankD().getWidth();
    public static int HEIGHT = ResourceMgr.getGoodTankD().getHeight();
    private boolean moving = true;
    private boolean live = true;
    private Random random = new Random();
    private Rectangle rect = new Rectangle();
    private FireStrategy fireStrategy;
    private int oldX;
    private int oldY;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        String fsName = PropertyMgr.getString(this.group == Group.GOOD ? "goodTankFireStrategy" : "badTankFireStrategy");
        try {
            fireStrategy = (FireStrategy) Class.forName(fsName).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        GameModel.getInstance().add(this);

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!live) {
            GameModel.getInstance().objects.remove(this);
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
        oldX = x;
        oldY = y;
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

    // 发射子弹
    public void fire() {
        /*int bX = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, this.dir, this.group, gameModel);*/
        fireStrategy.fire(this);
    }

    public void die() {
        this.live = false;
    }

    public Rectangle getRect() {
        return rect;
    }

    public FireStrategy getFireStrategy() {
        return fireStrategy;
    }

    public Dir getDir() {
        return dir;
    }

    // 回退上一步
    public void back() {
        x = oldX;
        y = oldY;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
