package com.xt.dp.strategy;

import java.util.Comparator;

/**
 * @author xt
 * @Desc
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o2.getHeight() - o1.getHeight();
    }
}
