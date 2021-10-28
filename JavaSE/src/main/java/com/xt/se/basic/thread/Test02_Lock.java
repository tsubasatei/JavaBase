package com.xt.se.basic.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xt
 * @Desc
 */
public class Test02_Lock {
    public static void main(String[] args) {
        MyProduct product = new MyProduct();
        MyProducer producer = new MyProducer(product);
        MyConsumer consumer = new MyConsumer(product);
        producer.start();
        consumer.start();
    }
}

class MyProduct {
    private String brand;
    private String name;
    public boolean flag = false; //默认情况下没有商品 让生产者先生产  然后消费者再消费
    private Lock lock = new ReentrantLock();
    private Condition proCondition = lock.newCondition();
    private Condition conCondition = lock.newCondition();

    public void produce(String brand, String name) {
        try {
            lock.lock();
            if (flag) {
                proCondition.await();
            }
            this.setBrand(brand);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            this.setName(name);
            System.out.println(Thread.currentThread().getName() + " 生产了" + this.getBrand() + " --- " + this.getName());
            flag = true;
            conCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer() {
        lock.lock();
        try {
            if (!flag) {
                conCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + " 消费了" + this.getBrand() + " --- " + this.getName());
            flag = false;
            proCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
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

class MyProducer extends Thread{

    private MyProduct p;

    public MyProducer(MyProduct p) {
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

class MyConsumer extends Thread {
    private MyProduct p;

    public MyConsumer(MyProduct p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            p.consumer();
        }
    }
}
