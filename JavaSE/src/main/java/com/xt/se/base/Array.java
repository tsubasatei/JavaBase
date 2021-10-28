package com.xt.se.base;

import java.time.LocalDate;

/**
 * @author xt
 * @Desc
 */
public class Array {
    public static void main(String[] args) {
        Object[] objs = new Object[3];
        objs[0] = 18;
        objs[1] = 98.2;
        objs[2] = 'c';
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }

        System.out.println();

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = {56, 98, 34, 89, 100}; // 不可分开写
        System.out.println(arr2.length);
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[i];
        }
        System.out.println("平均值：" + (double)sum / arr2.length);

        // 二位数组
        int[][] arr3 = new int[3][];
        arr3[0] = new int[5];
        arr3[1] = new int[3];
        arr3[2] = new int[4];

        arr3[0][0] = 1;
        arr3[0][1] = 2;
        arr3[0][2] = 3;
        arr3[0][3] = 4;
        arr3[0][4] = 5;

        arr3[1][0] = 6;
        arr3[1][1] = 7;
        arr3[1][2] = 8;

        arr3[2][0] = 9;
        arr3[2][1] = 10;
        arr3[2][2] = 11;
        arr3[2][3] = 12;

        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + "\t");
            }
            System.out.println();
        }

        LocalDate ld = LocalDate.now();
        LocalDate localDate = ld.plusDays(196);
        System.out.println(localDate);

    }
}
