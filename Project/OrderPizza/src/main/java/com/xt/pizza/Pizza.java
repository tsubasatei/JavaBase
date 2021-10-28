package com.xt.pizza;

/**
 * @author xt
 * @Desc
 */
public abstract class Pizza {
    private String name;
    private int price;
    private int size;

    public Pizza(String name, int price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String showInfo() {
        return "名称：" + name + "\n价格：" + price + "元\n大小：" + size + "寸";
    }
}
