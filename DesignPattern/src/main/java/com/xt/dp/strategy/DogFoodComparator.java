package com.xt.dp.strategy;

import java.util.Comparator;

/**
 * @author xt
 * @Desc
 */
public class DogFoodComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getFood() - o2.getFood();
    }
}
