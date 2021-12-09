package com.xt.dp.strategy;

import java.util.Comparator;

/**
 * @author xt
 * @Desc
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getWeight() - o2.getHeight();
    }
}
