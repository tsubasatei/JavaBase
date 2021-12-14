package com.xt.dp.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc 加入多个观察者
 */
public class Main5 {
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
        for (Observer o : observers) {
            o.actionOnWakeUp();
        }
    }

}
interface Observer{
    void actionOnWakeUp();
}
class Dad implements Observer{
    public void feed() {
        System.out.println("dad feeding");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Dog implements Observer{
    public void bark() {
        System.out.println("dog barking");
    }

    @Override
    public void actionOnWakeUp() {
        bark();
    }
}

class Mom implements Observer{
    public void hug() {
        System.out.println("mom hugging");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}
