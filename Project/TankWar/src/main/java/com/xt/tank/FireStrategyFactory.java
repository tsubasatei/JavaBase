package com.xt.tank;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xt
 * @Desc
 */
public class FireStrategyFactory {

    public static FireStrategy getFireStrategy(Group group) {
        String className = null;
        if (group == Group.GOOD) {
            className = PropertyMgr.getInstance().get("goodTankFireStrategy");
        } else if (group == Group.BAD) {
            className = PropertyMgr.getInstance().get("badTankFireStrategy");
        }
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            FireStrategy fireStrategy = (FireStrategy) declaredConstructor.newInstance();
            return fireStrategy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
