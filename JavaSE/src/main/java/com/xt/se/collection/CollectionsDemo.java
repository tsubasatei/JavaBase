package com.xt.se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Collections.addAll(list, "e", "f", "g");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        int i = Collections.binarySearch(list, "e");
        System.out.println(i + " - " + list.get(i));

        Collections.fill(list, "abc");
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Object[] array = list1.toArray();
    }
}
