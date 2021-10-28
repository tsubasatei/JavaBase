package com.xt.se.thread.pc;

/**
 * @author xt
 * @Desc
 */
public class Product {
    private String brand;
    private String name;

    boolean flag = false; // false 没有商品，可以生产，否则，进行消费

    public Product() {
    }

    public Product(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void produce(String brand, String name) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        this.setName(name);
        System.out.println(Thread.currentThread().getName() + " 生产了：" + this.getBrand() + "--" + this.getName());
        flag = true;
        notify();
    }

    public synchronized void consume() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 消费了：" + this.getBrand() + "--" + this.getName());
        flag = false;
        notify();
    }
}
