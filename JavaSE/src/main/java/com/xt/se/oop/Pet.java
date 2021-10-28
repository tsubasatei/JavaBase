package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public abstract class Pet {
    private String name;
    private Integer age;
    private String gender;

    public Pet() {
        System.out.println("Pet 无参");
    }

    public Pet(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public abstract void feed();
    public abstract void play() ;
    public void eat() {
        System.out.println(this.name + "在吃");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static void test() {
        System.out.println("static test");
    }
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
