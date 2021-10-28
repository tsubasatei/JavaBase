package com.xt.pizza;

/**
 * @author xt
 * @Desc
 */
public class FruitPizza extends Pizza {
    private String fruits;

    public FruitPizza(String name, int price, int size, String fruits) {
        super(name, price, size);
        this.fruits = fruits;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "\n水果配料：" + fruits;
    }

    public String getFruits() {
        return fruits;
    }

    public void setFruits(String fruits) {
        this.fruits = fruits;
    }
}
