package model.chainOfResponsibility;

import model.Bullet;
import model.GameObject;
import model.Tank;
import model.Wall;

/**
 * @author xt
 * @Desc
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.getRect().intersects(wall.getRect())) {
                tank.back();
            }
            return true;
        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            return collide(o2, o1);
        } else {
            return true;
        }
    }
}
