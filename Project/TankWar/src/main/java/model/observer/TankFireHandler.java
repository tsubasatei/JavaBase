package model.observer;

/**
 * @author xt
 * @Desc
 */
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionFire(TankFireEvent event) {
        event.getSource().fire();
    }
}
