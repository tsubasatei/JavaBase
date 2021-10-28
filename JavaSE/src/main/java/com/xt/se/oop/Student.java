package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Student {
    int stuNumber;
    String name;
    int age = 20;

    void study() {
        System.out.println("我正在学习");
    }

    void eat(String food) {
        System.out.println("我在吃" + food);
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.stuNumber);
        student.stuNumber = 20211010;
        student.name = "张三";
        student.age = 18;
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.stuNumber);
        student.study();
        student.eat("apple");
    }

}
