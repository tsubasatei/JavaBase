package com.xt.se.base;

import java.util.Arrays;

/**
 * @author xt
 * @Desc
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {4, 1,7, 2, 9, 3, 5, 8};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
