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
        colliders.add(new BulletTankCollider());
        colliders.add(new TankTankCollider());
        colliders.add(new BulletWallCollider());
        colliders.add(new TankWallCollider());
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (Collider collider : colliders) {
            if (!collider.collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
