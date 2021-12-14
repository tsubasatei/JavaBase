package com.xt.dp.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc 有很多时候，观察者需要根据事件的具体情况来进行处理
 */
public class Main6 {
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
    }
    public boolean isCry () {
        return cry;
    }
    public void wakeUp() {
        cry = true;
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer o : observers) {
            o.actionOnWakeUp(wakeUpEvent);
        }
    }

}

class WakeUpEvent {
    private long timestamp;
    private String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
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
