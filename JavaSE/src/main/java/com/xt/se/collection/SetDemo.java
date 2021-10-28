package com.xt.se.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xt
 * @Desc 比较器都存在，用外部比较器
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.add(2));
        System.out.println(set);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }


        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(4);
        treeSet.add(6);
        for (Integer i : treeSet) {
            System.out.println(i);
        }

        System.out.println(treeSet.ceiling(1));

        Dog dog1 = new Dog("大黄", "red", 2);
        Dog dog2 = new Dog("二黄", "black", 3);
        Dog dog3 = new Dog("三黄", "green", 1);
        TreeSet<Dog> ts = new TreeSet<>(new DogComparator());
        ts.add(dog1);
        ts.add(dog2);
        ts.add(dog3);
        System.out.println(ts);
    }
}
