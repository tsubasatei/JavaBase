package model.chainOfResponsibility;

import model.*;

/**
 * @author xt
 * @Desc
 */
public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.getRect().intersects(wall.getRect())) {
                bullet.die();
            }
            return true;
        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            return collide(o2, o1);
        } else {
            return true;
        }
    }
}
