package com.xt.dp.observer.v3;

/**
 * @author xt
 * @Desc 加入观察者
 */
public class Main3 {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    public boolean isCry () {
        return cry;
    }
    public void wakeUp() {
        cry = true;
        dad.feed();
    }

}
class Dad {
    public void feed() {
        System.out.println("dad feeding");
    }
}
