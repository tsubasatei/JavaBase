package model.chainOfResponsibility;

import model.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders;

    public ColliderChain() {
        colliders = new ArrayList<>();
        colliders.add(new BulletTankCollider());
        colliders.add(new TankTankCollider());
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        boolean flag = false;
        for (Collider collider : colliders) {
            flag = collider.collide(o1, o2);
            if (flag) {
                continue;
            }
        }
        return flag;
    }
}
