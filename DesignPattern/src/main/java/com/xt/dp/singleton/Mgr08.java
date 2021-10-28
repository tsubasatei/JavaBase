package com.xt.dp.singleton;


/**
 * @author xt
 * @Desc 枚举没有构造方法，抽象类，可以防止反序列化，反序列化后还是同一个对象
 */
public enum Mgr08 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Mgr08.INSTANCE.hashCode())).start();
        }

    }
}
