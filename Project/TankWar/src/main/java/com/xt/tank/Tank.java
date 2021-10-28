package com.xt.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author xt
 * @Desc
 */
public class Tank {
    private int x;
    private int y;
    public static final int WIDTH = ResourceMgr.getGoodTankD().getWidth();
    public static final int HEIGHT = ResourceMgr.getGoodTankD().getHeight();
    private Dir dir;
    public static final int SPEED = Integer.parseInt(PropertyMgr.getInstance().get("tankSpeed"));
    private boolean isMoving = true;
    private Group group;
    private TankFrame frame;
    private Random random = new Random();
    private Rectangle rectangle = new Rectangle();
    private FireStrategy strategy = DefaultFireStrategy.getInstance();

    private boolean isLive = true;
    public Tank() {
    }

    public Tank(Integer x, Integer y, Dir dir, Group group, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.frame = frame;
        this.strategy = FireStrategyFactory.getFireStrategy(group);

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }


    public void paint(Graphics g) {
        if (!isLive) frame.getEnemyTanks().remove(this);
        switch(dir) {
            case LEFT:
                g.drawImage(group == Group.GOOD ? ResourceMgr.getGoodTankL() : ResourceMgr.getBadTankL(), x, y, null);
                break;
            case UP:
                g.drawImage(group == Group.GOOD ? ResourceMgr.getGoodTankU() : ResourceMgr.getBadTankU(), x, y, null);
                break;
            case RIGHT:
                g.drawImage(group == Group.GOOD ? ResourceMgr.getGoodTankR() : ResourceMgr.getBadTankR(), x, y, null);
                break;
            case DOWN:
                g.drawImage(group == Group.GOOD ? ResourceMgr.getGoodTankD() : ResourceMgr.getBadTankD(), x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if (!isMoving) return;
        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD) {
            if (random.nextInt(100) > 95) {
                this.setDir(Dir.values()[random.nextInt(4)]);
            }
            if (random.nextInt(100) > 95) {
                this.fire();
            }
        }
        boundsCheck();

        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    // 边界检测
    private void boundsCheck() {
        if (x < 2) x = 2;
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (y < Tank.HEIGHT / 2 - 2) y = Tank.HEIGHT / 2 - 2;
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_WIDTH - Tank.HEIGHT -2 ;
    }

    public void die() {
        this.isLive = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Group getGroup() {
        return group;
    }


    public void fire() {
//        Bullet bullet = new Bullet(this.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2,
//                this.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2,
//                this.getDir(), this.getGroup(), this.frame);
//        this.frame.getBullets().add(bullet);

        // 用策略模式
        strategy.fire(this);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public TankFrame getFrame() {
        return frame;
    }

    public boolean isLive() {
        return isLive;
    }
}
