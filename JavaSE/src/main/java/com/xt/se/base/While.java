package com.xt.se.base;

/**
 * @author xt
 * @Desc
 */
public class While {
    public static void main(String[] args) {
        /*int i = 1;
        while (i <= 100) {
            System.out.println("第" + i + "遍输出");
            i++;
        }*/

        /*int j = 1;
        int sum = 0;
        while (j <= 100) {
            if (j % 2 == 0) {
                sum += j;
            }
            j++;
        }
        System.out.println("100以内的偶数和: " + sum);
        System.out.println(j);*/

        /*int i = 1;
        do {
            System.out.println("第" + i + "遍输出");
            i++;
        } while (i <= 100);
        System.out.println(i);*/

        int j = 1;
        int sum = 0;
        do {
            if (j % 2 == 0) {
                sum += j;
            }
            j++;
        } while (j <= 100);
        System.out.println("100以内的偶数和: " + sum);
        System.out.println(j);
    }
}
