package com.xt.se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author xt
 * @Desc
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(true);
        collection.add(1.23);
        collection.add("abc");
        System.out.println(collection);
        ((ArrayList)collection).add(0, "yume");
        System.out.println(collection);
        Collection coll2 = new ArrayList();
        coll2.add("a");
        coll2.add("b");
        coll2.add("c");
        collection.addAll(coll2);
        System.out.println(collection);
//        collection.clear();
//        System.out.println(collection);
        System.out.println(collection.contains("a"));
        System.out.println(collection.contains(coll2));
        System.out.println(collection.isEmpty());
        collection.stream().forEach(System.out::println);
        collection.remove("a");
        System.out.println(collection);
        System.out.println(collection.retainAll(coll2));
        System.out.println(collection);
        System.out.println(collection.size());
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
    }
}
