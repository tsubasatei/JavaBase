package com.xt.se.basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author xt
 * @Desc
 */
public class Test01_Synchronized {
    public static void main(String[] args) {
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        producer.start();
        consumer.start();
    }
}

class Product {
    private String brand;
    private String name;
    public boolean flag = false; //默认情况下没有商品 让生产者先生产  然后消费者再消费

    public synchronized void produce(String brand, String name) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        this.setName(name);
        System.out.println(Thread.currentThread().getName() + " 生产了" + this.getBrand() + " --- " + this.getName());
        flag = true;
        notify();
    }

    public synchronized void consumer() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 消费了" + this.getBrand() + " --- " + this.getName());
        flag = false;
        notify();
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Producer extends Thread{

    private Product p;

    public Producer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                p.produce("费列罗", "巧克力");
            } else {
                p.produce("康师傅", "冰红茶");
            }
        }
    }
}

class Consumer extends Thread {
    private Product p;

    public Consumer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            p.consumer();
        }
    }
}
