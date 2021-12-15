package model.observer;

import model.Tank;

/**
 * @author xt
 * @Desc
 */
public class TankFireEvent {
    private Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource() {
        return tank;
    }
}
