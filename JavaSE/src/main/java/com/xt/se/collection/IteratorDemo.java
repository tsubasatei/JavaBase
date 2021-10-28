package com.xt.se.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author xt
 * @Desc
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (i == 1) {
                listIterator.remove();
            }
            System.out.println(i);
        }
        list.forEach(x -> System.out.println(x));

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
