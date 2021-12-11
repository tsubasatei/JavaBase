package model;

import model.chainOfResponsibility.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class GameModel {

    Tank tank = new Tank(200, 600, Dir.UP, Group.GOOD,this);
    List<GameObject> objects = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    public GameModel() {
        Integer enemyTankCount = PropertyMgr.getInt("enemyTankCount");
        for (int i = 0; i < enemyTankCount; i++) {
            objects.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject gameObject) {
        objects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        objects.remove(gameObject);
    }

    public void paint(Graphics g) {
        /*Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + enemies.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);*/

        tank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                chain.collide(objects.get(i), objects.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return tank;
    }
}
