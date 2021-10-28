package com.xt.se.oop;

import java.util.Scanner;

/**
 * @author xt
 * @Desc
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "abc";
        String str1 = "abc";
        System.out.println(str == str1);
        System.out.println(str.equals(str1));

        Scanner sc = new Scanner(System.in);
        String str2 = sc.next();
        System.out.println(str == str2);
        System.out.println(str.equals(str2));

        String str3 = new String("abc");
        System.out.println(str == str3);
        System.out.println(str.equals(str3));



    }
}
