package com.xt.dp.singleton;

/**
 * @author xt
 * @Desc
 */
public class Mgr01 {

    private static final Mgr01 instance = new Mgr01();
    private Mgr01() {

    }
    public static Mgr01 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Mgr01 instance = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance == instance2);
    }
}
