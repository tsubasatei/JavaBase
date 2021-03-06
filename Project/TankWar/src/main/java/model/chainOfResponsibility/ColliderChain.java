package model.chainOfResponsibility;

import model.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders = new ArrayList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
