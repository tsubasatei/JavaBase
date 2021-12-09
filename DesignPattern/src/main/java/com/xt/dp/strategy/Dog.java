package com.xt.dp.strategy;

/**
 * @author xt
 * @Desc
 */
public class Dog implements Comparable<Dog>{
    private int food;

    public Dog(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        return o.getFood() - this.getFood();
    }
}
