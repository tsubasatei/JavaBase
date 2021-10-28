package com.xt.se.oop;

/**
 * @author xt
 * @Desc 创建子类对象优先创建父类对象
 * 不能继承：父类private，构造器
 * 父类的静态方法可以被继承，但是不能被重写
 */
public class Cat extends Pet {

    private String sound;
    public Cat() {
        System.out.println("Dog 无参");
    }

    public Cat(String name, Integer age, String gender, String sound) {
        super(name, age, gender);
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public void play() {
        System.out.println("dog is playing a ball");
    }

    @Override
    public void feed() {
        System.out.println("猫在吃鱼");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "sound='" + sound + "\', " + super.toString() +
                '}';
    }
}
