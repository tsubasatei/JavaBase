package com.xt.dp.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc 有很多时候，观察者需要根据事件的具体情况来进行处理
 */
public class Main8 {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Dog());
        observers.add(new Mom());
        observers.add((e) -> System.out.println("ppp"));
        //hook callback function
    }
    public boolean isCry () {
        return cry;
    }
    public void wakeUp() {
        cry = true;
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        for (Observer o : observers) {
            o.actionOnWakeUp(wakeUpEvent);
        }
    }

}
abstract class Event<T> {
    abstract T getSource();
}
class WakeUpEvent extends Event<Child> {
    private long timestamp;
    private String loc;
    private Child child;
    public WakeUpEvent(long timestamp, String loc, Child child) {
        this.timestamp = timestamp;
        this.loc = loc;
    }

    @Override
    public Child getSource() {
        return child;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}

class Dad implements Observer{
    public void feed() {
        System.out.println("dad feeding");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }
}

class Dog implements Observer{
    public void bark() {
        System.out.println("dog barking");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        bark();
    }
}

class Mom implements Observer{
    public void hug() {
        System.out.println("mom hugging");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        hug();
    }
}
