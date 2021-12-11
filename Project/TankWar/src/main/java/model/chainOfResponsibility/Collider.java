package model.chainOfResponsibility;

import model.GameObject;

/**
 * @author xt
 * @Desc
 */
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
