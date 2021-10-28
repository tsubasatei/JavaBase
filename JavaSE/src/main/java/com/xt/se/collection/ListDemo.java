package com.xt.se.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author xt
 * @Desc
 */
public class ListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add(1);
        list.add("a");
        list.add(true);
        System.out.println(list);
        System.out.println(list.get(2));
        list.indexOf("a");
        list.lastIndexOf("a");
        List list1 = list.subList(0, 2);
        System.out.println(list1);
        List<Integer> list2 = List.of(1, 2, 3, 4);
        System.out.println(list2);

        System.out.println("----------");

        Vector vector = new Vector();
        vector.add(1);
    }
}
