package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class DogMain {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog = new Dog("大黄", 2, "男", "");
        System.out.println(dog);
        dog.test();
        Dog.test();
    }
}
