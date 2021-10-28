package com.xt.pizza;

/**
 * @author xt
 * @Desc
 */
public class BaconPizza extends Pizza {
    private int weight;

    public BaconPizza(String name, int price, int size, int weight) {
        super(name, price, size);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "\n培根克数：" + weight + "g";
    }
}
