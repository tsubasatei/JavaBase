package com.xt.se.basic.base;

import java.util.Scanner;

public class Test02_Scanner {
    public static void main(String[] args) {
        // 键盘录入学生的信息: 年龄、身高、姓名、性别
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------录入学生信息------------");
        System.out.print("姓名：");
        String name = sc.next();
        System.out.print("年龄：");
        int age = sc.nextInt();
        System.out.print("身高（m）：");
        double height = sc.nextDouble();
        System.out.print("性别（男/女）：");
        char gender = sc.next().charAt(0);
        System.out.println("---------学生信息如下：--------");
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("身高：" + height + "m");
        System.out.println("性别：" + gender);
    }
}
