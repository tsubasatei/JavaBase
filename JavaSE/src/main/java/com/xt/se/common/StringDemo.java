package com.xt.se.common;

/**
 * @author xt
 * @Desc
 * 常量池在1.7之后放置在堆空间之中
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "abcdef";
        String str2 = new String("abcdef");
        String str3 = str2.intern();
        System.out.println(str == str2); // false
        System.out.println(str == str3); // true
        System.out.println(str.equals(str2));

        System.out.println(str.charAt(0));
        System.out.println(str.concat("cde"));
        System.out.println(str.indexOf("c"));
        System.out.println(str.substring(3));
        System.out.println(str.substring(3, 5));
        System.out.println(str.length());

        System.out.println("-----------");

        String a = "abc";
        String b = "def";
        String c = "abcdef";
        String d = a + b;
        String e = "abc" + "def";
        System.out.println(c == d); // false
        System.out.println(c == e); // true

        System.out.println("-----------");

        // 线程安全
        StringBuffer sb = new StringBuffer();
        sb.append(1).append(3.14).append(str).append(true);
        System.out.println(sb);
        System.out.println(sb.length()); // 15
        System.out.println(sb.capacity()); // 16

        // 线程不安全，效率高
        StringBuilder sb2 = new StringBuilder();
        sb2.append(1).append(3.14).append(str).append(true);
        System.out.println(sb2);
        System.out.println(sb2.length()); // 15
        System.out.println(sb2.capacity()); // 16


    }
}
