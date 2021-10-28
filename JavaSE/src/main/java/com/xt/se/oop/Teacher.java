package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class Teacher {
    String name;
    int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void teach() {
        System.out.println("上课");
    }
    public void teach(int a) {
        System.out.println("上课");
    }
    public void teach(String a) {
        System.out.println("上课");
    }
    public void teach(int b, String a) {
        System.out.println("上课");
    }
    public void teach(String a, int b) {
        System.out.println("上课");
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("连", 20);
        teacher.teach();
        System.out.println(teacher.name);
        System.out.println(teacher.age);

        teacher = new Teacher();
        teacher.teach();
        System.out.println(teacher.name);
        System.out.println(teacher.age);
    }
}
