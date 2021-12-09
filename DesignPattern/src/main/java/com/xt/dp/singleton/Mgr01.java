package com.xt.dp.singleton;

/**
 * @author xt
 * @Desc 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 唯一缺点：不管用到与否，类装载时就完成实例化
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
