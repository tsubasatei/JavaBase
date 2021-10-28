package com.xt.se.collection;

import java.util.LinkedList;

/**
 * @author xt
 * @Desc
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add(false);
        list.add("abc");
        System.out.println(list);

        list.add(0, "yume");
        System.out.println(list);
        list.addFirst("111");
        System.out.println(list);
        list.addLast("222");
        System.out.println(list);
        System.out.println(list.element());
        System.out.println(list.offer("444"));
        System.out.println(list);
    }
}
