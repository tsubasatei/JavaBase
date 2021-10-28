package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Penguin extends Pet {
    private String color;

    @Override
    public void feed() {
        System.out.println("企鹅在吃小虾");
    }

    public Penguin() {
    }

    public Penguin(String name, Integer age, String gender, String color) {
        super(name, age, gender);
        this.color = color;
    }

    @Override
    public void play() {
        System.out.println("Penguin is playing ice");
    }
}
