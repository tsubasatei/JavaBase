package com.xt.dp.singleton;

/**
 * @author xt
 * @Desc 同01
 */
public class Mgr02 {

    private static Mgr02 instance;
    static {
        instance = new Mgr02();
    }
    private Mgr02() {

    }
    public static Mgr02 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Mgr02 instance = Mgr02.getInstance();
        Mgr02 instance2 = Mgr02.getInstance();
        System.out.println(instance == instance2);
    }
}
