package com.xt.se.collection;

import java.util.ArrayList;

/**
 * @author xt
 * @Desc
 */
public class DogMain {
    public static void main(String[] args) {
        ArrayList<Dog> list = new ArrayList<>();
        Dog dog1 = new Dog("大黄", "red", 2);
        Dog dog2 = new Dog("二黄", "black", 3);
        Dog dog3 = new Dog("三黄", "green", 1);

        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(dog1);
        System.out.println(list);
        Dog dog = new Dog("三黄", "green", 1);
        System.out.println(list.contains(dog));

    }
}
