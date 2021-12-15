package model.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xt
 * @Desc
 */
class Bullet {
    private UUID id = UUID.randomUUID();
    boolean live = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}
public class BulletPool {
    private List<Bullet> bullets = new ArrayList<>();
    {
        for (int i = 0; i < 5; i++) {
            bullets.add(new Bullet());
        }
    }
    public Bullet getBullet() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (!bullet.live) {
                return bullet;
            }
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool pool = new BulletPool();
        for (int i = 0; i < 10; i++) {
            System.out.println(pool.getBullet());
        }
    }
}
