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
    private static final GameModel INSTANCE = new GameModel();
    Tank tank;
    List<GameObject> objects = new ArrayList<>();
    ColliderChain chain = new ColliderChain();
    static {
        INSTANCE.init();
    }

    private void init() {
        tank = new Tank(200, 600, Dir.UP, Group.GOOD);
        Integer enemyTankCount = PropertyMgr.getInt("enemyTankCount");
        for (int i = 0; i < enemyTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }
        // 初始化墙
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }

    private GameModel() {

    }
    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject gameObject) {
        objects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        objects.remove(gameObject);
    }

    public void paint(Graphics g) {

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
