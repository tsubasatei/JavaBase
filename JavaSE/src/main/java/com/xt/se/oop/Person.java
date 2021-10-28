package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Person {

    public void feed(Pet pet) {
        pet.feed();
    }

    public Pet buyPet(int type) {
        if (1 == type) {
            return new Dog();
        } else if (2 == type) {
            return new Cat();
        } else {
            return new Penguin();
        }

    }

    public static void main(String[] args) {
        Person person = new Person();
        Pet pet = new Dog();
        person.feed(pet);
        pet = new Cat();
        person.feed(pet);

        Pet p = person.buyPet(1);
        if (p instanceof Dog) {
            System.out.println("买的是一条狗");
        } else if (p instanceof Cat) {
            System.out.println("买的是一只猫");
        } else {
            System.out.println("买的是一只企鹅");
        }
    }
}
