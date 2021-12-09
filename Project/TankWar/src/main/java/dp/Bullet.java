package dp;

import java.awt.*;

/**
 * @author xt
 * @Desc 子弹
 */
public class Bullet {
    private int x;
    private int y;
    private Dir dir;
    private Group group;
    private TankFrame tf;
    private boolean live = true;
    public static final int SPEED = PropertyMgr.getInt("bulletSpeed");
    public static int WIDTH = ResourceMgr.getBulletD().getWidth();
    public static int HEIGHT = ResourceMgr.getBulletD().getHeight();
    private Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf =  tf;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.tf.getBullets().add(this);
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
            return;
        }
        switch (dir) {
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
        }

        move();
    }

    private void move() {
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

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }

        rect.x = x;
        rect.y = y;
    }

    // 碰撞检测
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (rect.intersects(tank.getRect())) {
            this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(new Explode(eX, eY, tank.getTf()));
        }
    }

    private void die() {
        this.live = false;
    }
}
