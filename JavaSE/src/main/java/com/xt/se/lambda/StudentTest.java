package com.xt.se.lambda;

import java.util.ArrayList;

/**
 * @author xt
 * @Desc
 */
public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));

        // 年龄大于14的学生
        list.stream().filter(s -> s.getAge() > 14).forEach(System.out::println);

        System.out.println();
        // 分数大于75的学生
        list.stream().filter(s -> s.getScore() > 75).forEach(System.out::println);
    }
}
