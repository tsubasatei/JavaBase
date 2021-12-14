package com.xt.dp.observer.v4;

/**
 * @author xt
 * @Desc 加入多个观察者
 */
public class Main4 {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Dog dog = new Dog();
    private Mom mom = new Mom();
    public boolean isCry () {
        return cry;
    }
    public void wakeUp() {
        cry = true;
        dad.feed();
        dog.bark();
        mom.hug();
    }

}

class Dad {
    public void feed() {
        System.out.println("dad feeding");
    }
}
class Dog {
    public void bark() {
        System.out.println("dog barking");
    }
}
class Mom {
    public void hug() {
        System.out.println("mom hugging");
    }
}
