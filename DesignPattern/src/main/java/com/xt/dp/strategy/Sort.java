package com.xt.dp.strategy;

import java.util.Comparator;

/**
 * @author xt
 * @Desc
 */
public class Sort<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = comparator.compare(arr[j], arr[minValueIndex]) < 0 ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
