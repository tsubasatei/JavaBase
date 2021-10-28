package com.xt.tank;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class Bullet {
    private int x;
    private int y;
    public static final int WIDTH = ResourceMgr.getBulletD().getWidth();
    public static final int HEIGHT = ResourceMgr.getBulletD().getHeight();
    private static final int SPEED =  Integer.parseInt(PropertyMgr.getInstance().get("bulletSpeed"));;;
    private Dir dir;
    private boolean isLive = true;
    private TankFrame frame;
    private Group group;
    private Rectangle rectangle = new Rectangle();

    public Bullet() {
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.frame = frame;
        this.frame.getBullets().add(this);

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!isLive) frame.getBullets().remove(this);
        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.getBulletL(), x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.getBulletU(), x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.getBulletR(), x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.getBulletD(), x, y, null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
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

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.setLive(false);
        }

        rectangle.x = this.x;
        rectangle.y = this.y;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    // 碰撞检测
    public void collideWithTank(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (this.getRectangle().intersects(tank.getRectangle())) {
            this.die();
            tank.die();
            // 调整爆炸位置
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.EXPLODE_WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.EXPLODE_HEIGHT / 2;
            this.frame.getExplodes().add(new Explode(eX, eY, this.frame));
        }
    }

    private void die() {
        this.setLive(false);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
